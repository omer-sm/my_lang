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
        String code =
                """
                // boolean literals and nil
                a @= true
                console.log("should be false: ", a == nil)
                
                // cond
                cond {
                    a == 2: console.log("a = 2")
                    a == 1: console.log("a = 1")
                    a == 0: {
                        console.log("a = 0. this is a block")
                    }
                    any: console.log("a didn't match any cond clause")
                }
                
                // cond! and arrays
                b @= [1, 2, 3]
                console.log("b length: ", cond! {
                    b.length > 5: "> 5"
                    b.length > 2: "> 2"
                    any: "<= 2"
                })
                
                // match and match!
                match (b.length) {
                    1: {
                        console.log("1, non breaking")
                    }
                    2 => console.log(2)
                    any => console.log("other")
                }
                console.log(match! (b.length) {
                    1 => "one"
                    2 => "two"
                    3 => "three"
                    any => "other"
                })
                """;
        CodeLexer lexer = new CodeLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CodeParser parser = new CodeParser(tokens);
        ParseTree tree = parser.program();
        System.out.println(tree.toStringTree(parser));

        CodeAstVisitor visitor = new CodeAstVisitor();
        Map<String, Object> res = visitor.visit(tree);
        Gson gson = new GsonBuilder().serializeNulls().create();
        System.out.println(gson.toJson(res));

        /* OLD CODE:
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
                def f(arg): arg + 1

                func(1)
                :> func(4)
                :> func(3)

                obj.fun(5)
                ~> fun(8)
                :> obj.fun(2)
                ~> fun(1)
                """;
         */
    }

}