import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gen.CodeLexer;
import gen.CodeParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // TO TEST:
        // -- boolean literals (if work with spaces)
        // -- nil literals (if _ works and doesn't make it an identifier)
        // -- if cond even works
        // export default (if visitChildren works properly) and export / import in general

        Transpiler.transpileAndRunFile("code files/agifytest.xprs");
    }

}