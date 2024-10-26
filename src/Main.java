import com.google.gson.Gson;
import gen.CodeLexer;
import gen.CodeParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String code =
                """
                a := 1
                f @= #/1{console.log(#1)}
                while (a < 5) {
                    if (a == 2) {
                        skip
                    }
                    f(a)
                    a++
                }
                for (i := 0; i < 5; i++) {
                    console.log(i)
                }
                @async
                def func(arg, arg2 ?= 3) {
                    console.log(arg + arg2)
                }
                def f(arg), return: arg + 1
                
                func(1)
                :> func(4)
                :> func(3)
                
                obj.fun(5)
                ~> fun(8)
                :> obj.fun(2)
                ~> fun(1)
                """;
        CodeLexer lexer = new CodeLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CodeParser parser = new CodeParser(tokens);
        ParseTree tree = parser.program();
        System.out.println(tree.toStringTree(parser));

        CodeAstVisitor visitor = new CodeAstVisitor();
        Map<String, Object> res = visitor.visit(tree);
        Gson gson = new Gson();
        System.out.println(gson.toJson(res));

        /*String code =
                """
                console.log("hi")
                """;
        JavaScriptLexer lexer = new JavaScriptLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaScriptParser parser = new JavaScriptParser(tokens);
        ParseTree tree = parser.program();
        System.out.println(tree.getText());*/

        //ElixirParserVisitor visitor = new ElixirParserVisitor();
        //String res = visitor.visit(tree);
        //System.out.println(res);
    }

}