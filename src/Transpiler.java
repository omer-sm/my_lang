import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gen.CodeLexer;
import gen.CodeParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class Transpiler {
    public static String transpileToAST(String code) {
        System.out.println("Starting transpilation process..");
        CodeLexer lexer = new CodeLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CodeParser parser = new CodeParser(tokens);
        ParseTree tree = parser.program();
        System.out.println("Parsed successfully. Transpiling..");

        CodeAstVisitor visitor = new CodeAstVisitor();
        Map<String, Object> res = visitor.visit(tree);
        Gson gson = new GsonBuilder().serializeNulls().create();
        System.out.println("Transpilation complete.");
        return gson.toJson(res);
    }

    public static String transpileFileToAST(String path) {
        System.out.println("Reading file at " + path + "..");
        try {
            File f = new File(path);
            if (!path.endsWith(".xprs")) {
                System.out.println("Warning: file at " + path + " does not end in .xprs and may not be an xprs file.");
            }
            Scanner reader = new Scanner(f);
            StringBuilder sb = new StringBuilder();
            while (reader.hasNextLine()) {
                sb.append(reader.nextLine()).append('\n');
            }
            System.out.println("File read successfully.");
            reader.close();
            return transpileToAST(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Error: File at " + path + " not found.");
            e.printStackTrace();
        }
        return "Unexpected file reading error";
    }

    public static String doCodegen(String ast) {
        try {
            // Command to execute Node.js with the script
            ProcessBuilder processBuilder = new ProcessBuilder("node", "js_src/codegen.mjs");
            // Start the process
            Process process = processBuilder.start();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

            // Write to stdin
            writer.write(ast);
            writer.flush();  // Ensure the data is sent

            // Close the writer
            writer.close();
            // Read output from the JavaScript process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line of errors from the script
            }

            // Wait for the process to exit and get the exit code
            int exitCode = process.waitFor();
            System.out.println("Node process exited with code: " + exitCode);
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Unexpected codegen error.";
    }

    public static String transpileFile(String inPath, String outDir) {
        String code = doCodegen(transpileFileToAST(inPath));
        String outPath = (outDir.endsWith("/") ? outDir : outDir + '/') +
                inPath.substring(inPath.lastIndexOf('/')+1, inPath.lastIndexOf('.')) + ".mjs";
        try {
            File f = new File(outPath);
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
            } else {
                System.out.println("File " + f.getName() + " already exists.");
            }
            FileWriter fw = new FileWriter(outPath);
            fw.write(code);
            System.out.println("Wrote code to " + outPath + ".");
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return outPath;
    }

    public static void transpileAndRunFile(String inPath) {
        String outDir = inPath.substring(0, inPath.lastIndexOf('/')) + "/out/";
        new File(outDir).mkdir();
        String outPath = transpileFile(inPath, outDir);
        try {
            // Command to execute Node.js with the script
            ProcessBuilder processBuilder = new ProcessBuilder("node", outPath);
            // Start the process
            Process process = processBuilder.start();

            // Read output from the JavaScript process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line of errors from the script
            }

            // Wait for the process to exit and get the exit code
            int exitCode = process.waitFor();
            System.out.println("Node script run process exited with code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
