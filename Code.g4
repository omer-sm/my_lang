grammar Code;

/*
 * TO ADD:
 * functions can be 'def a(), throw: ...' to throw errors if they are triggered
 * arrow functions / named anon functions
 */

/*
 * Parser
 */

program: NL* statement* NL* EOF;

// base

statement: (expressionStatement
         | block
         | nestedStatement
         | variableDeclaration
         | ifStatement
         | whileStatement
         | doWhileStatement
         | forStatement
         | forIndexedStatement
         | forEachStatement
         | skipStatement
         | breakStatement
         | functionDeclaration
         | returnStatement
         | classDeclaration
         | importDeclaration
         | exportDeclaration
         | matchStatement
         | condStatement
         | throwStatement
         | guardStatement
         ) NL*;

expressionStatement: expression;

expression: anonFuncDef
            | unaryExpr
            | binaryExpr
            | logicExpr
            | ternaryExpr
            | assignmentExpr
            | functionCall
            | '(' expression ')'
            | generateExpression
            | literal
            | arrayExpression
            | objectExpression
            | newExpression
            | matchExpression
            | condExpression
            | waitforExpression
            | accessor
            ;

block: NL* '{' NL* statement* NL*'}' NL*;

nestedStatement: '(' NL* statement NL* ')';


// function calls

functionCall: regularFunctionCall
            | chainedFunctionCall
            | imposterFunctionCall;

regularFunctionCall: (accessor | anonFuncDef) '(' (functionArg (',' functionArg)*)? ')' ('.' functionCall)*;

chainedFunctionCall: (accessor | regularFunctionCall) NL* '~>' functionCall;

imposterFunctionCall: (accessor | regularFunctionCall) NL* ':>' functionCall;

functionArg: expression
          | spreadElement;


// function defs

anonFuncDef: '#/' NUM block;

functionDeclaration: functionAnnotations? 'def' identifier '(' (functionParam (',' functionParam)*) ')' NL* functionBody;

functionAnnotations: FUNCTION_ANNOTATION+ NL*;

functionParam: identifier
             | assignmentPattern;

functionBody: block
              | ':' expression;

returnStatement: 'return' expression;

generateExpression: 'generate' expression; // yield equivalent


// accessors, literals, etc

literal: STRING
        | NUM
        | thisLiteral
        | parentLiteral
        | nilLiteral
        | booleanLiteral
        | anonIdentifier
        | identifier
        ;

identifier: IDENTIFIER;

anonIdentifier: ANON_IDENTIFIER;

thisLiteral: 'this';

parentLiteral: 'parent';

booleanLiteral: 'true' | 'false';

nilLiteral: 'nil';

accessor: literal NL* ('.' accessor)?;

spreadElement: '..' expression;


// variables and pattern matching

variableDeclaration: variableDeclarator | bindingDeclaration;

variableDeclarator: identifier DECLARATION_OP expression;

assignmentExpr: (accessor | arrayPattern) ASSIGNMENT_OP expression;

assignmentPattern: identifier PARAM_ASSIGN_OP expression;

bindingDeclaration: arrayBindingDec | objectBindingDec;

arrayBindingDec: arrayPattern NL* DECLARATION_OP expression NL*;

objectBindingDec: objectPattern NL* DECLARATION_OP expression NL*;

bindingPattern: arrayPattern | objectPattern;


arrayExpression: '[' (arrayExpressionElement (',' arrayExpressionElement)*)? ']';

arrayExpressionElement: expression | spreadElement;

arrayPattern: '[' (arrayPatternElement (',' arrayPatternElement)*)? ']';

arrayPatternElement: (assignmentPattern | identifier | spreadElement | bindingPattern) NL*;


objectExpression: '{' (objectExpressionElement (',' objectExpressionElement)*)? '}';

objectExpressionElement: (literal ':' expression)
                         | ('@' literal);

objectPattern: '{' (objectPatternElement (',' objectPatternElement)*)? '}';

objectPatternElement: literal (PARAM_ASSIGN_OP expression)?;


// expressions

unaryExpr: (UNARY_OPERATOR expression)
        | (accessor POST_UNARY_OPERATOR);

binaryExpr: (accessor | functionCall) BINARY_OPERATOR expression;

logicExpr: (accessor | functionCall) BINARY_LOGIC_OP expression;

ternaryExpr: TERNARY_OP expression TERNARY_OP NL* expression NL* ':' NL* expression;

newExpression: 'new' accessor '(' (functionArg (',' functionArg)*)? ')';

waitforExpression: 'waitfor' expression; // await equivalent


// control flow statements

ifStatement: 'if' '(' expression ')' NL* statement NL* elseBlock?;

elseBlock: 'else' NL* statement;

whileStatement: 'while' '(' expression ')' NL* statement;

doWhileStatement: 'dowhile' '(' expression ')' NL* statement;

forStatement: 'for' '(' (expression | variableDeclaration) SEPARATOR
                NL* expression SEPARATOR NL* expression NL* ')' NL* statement;

forIndexedStatement: 'for' '(' '%' identifier NL* ':' NL* expression NL* ')' NL* statement;

forEachStatement: 'for' '(' identifier NL* ':' NL* expression NL* ')' NL* statement;

skipStatement: 'skip'; // continue equivalent

breakStatement: 'break';

throwStatement: 'throw' expression;

guardStatement: 'guard' NL* block NL* fromClause? NL* endwithClause?; // try equivalent

fromClause: 'from' identifier? block; // catch equivalent

endwithClause: 'endwith' block; // finally equivalent

// match + cond

logicStatementTest: expression | 'any';

matchStatement: 'match' '(' expression ')' matchBody; // switch/case equivalent

matchBody: '{' NL* (matchClause NL*)* NL* '}';

matchClause: (logicStatementTest ':' statement) #FullMatchClause
           | (logicStatementTest '=>' statement) #ShortMatchClause; // match clause with implicit break

matchExpression: 'match!' '(' expression ')' matchExpressionBody; // match with implicit return

matchExpressionBody: '{' NL* (matchExpressionClause NL*)* NL* '}';

matchExpressionClause: logicStatementTest '=>' expression;


condStatement: 'cond' condBody;

condBody: '{' NL* (condClause NL*)* NL* '}';

condClause: logicStatementTest ':' statement;

condExpression: 'cond!' condExpressionBody; // cond with implicit return

condExpressionBody: '{' NL* (condExpressionClause NL*)* NL* '}';

condExpressionClause: logicStatementTest ':' expression;


// classes

classDeclaration: 'defclass' identifier classParentDeclaration? classBody;

classParentDeclaration: ', childof' accessor;

classBody: methodDeclaration*;

methodDeclaration: (methodAnnotations? 'def' identifier '(' (functionParam (',' functionParam)*) ')' NL* methodBody) #MethodDef
                    | ('defctor' identifier '(' (functionParam (',' functionParam)*) ')' NL* methodBody) #CtorDef;

methodAnnotations: METHOD_ANNOTATION+ NL*;

methodBody: block
              | ':' expression;


// imports

importDeclaration: 'import' (importSpecifier (',' NL* importSpecifier)+ 'of')? STRING;

importSpecifier: ('defaults as' identifier) #DefaultImport
                | ('all as' identifier) #AllImport
                | (identifier ('as' identifier)?) #SpecificImport;


// exports

exportDeclaration: exportAllDeclaration | exportDefaultDeclaration | exportNamedDeclaration;

exportAllDeclaration: 'export all of' STRING;

exportDefaultDeclaration: 'export as default' (identifier | bindingPattern | classDeclaration | expression | functionDeclaration);

exportNamedDeclaration: ('export' exportSpecifier (',' NL* exportSpecifier)*)
                        | ('export' exportNamedDeclarationSpecifier);

exportSpecifier: (accessor 'as' accessor)
                | (accessor);

exportNamedDeclarationSpecifier: functionDeclaration | classDeclaration | variableDeclaration;



/*
 * Lexer
 */

NL: '\r'? '\n' | '\r';
WhiteSpaces: [\t\u000B\u000C\u0020\u00A0]+ -> channel(HIDDEN);
MultiLineComment  : '/*' .*? '*/'             -> channel(HIDDEN);
SingleLineComment : '//' ~[\r\n\u2028\u2029]* -> channel(HIDDEN);

NUM: [0-9]+ ('.'[0-9]+)?;
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;
ANON_IDENTIFIER: '#'[0-9]+;
STRING: '"' ~('"')* '"';
SEPARATOR: ';';

UNARY_OPERATOR: '!' | '-';
POST_UNARY_OPERATOR: '++' | '--';
BINARY_OPERATOR: '+' | '-' | '%' | '*' | '/' | '==' | '!=' | '===' | '<' | '>' | '<=' | '>=' ;
BINARY_LOGIC_OP: '&&' | '||';
ASSIGNMENT_OP: '+=' | '-=' | '%=' | '*=' | '/=' | '=';
DECLARATION_OP: '@=' | ':=';
TERNARY_OP: '?';
PARAM_ASSIGN_OP: '?=';

FUNCTION_ANNOTATION: '@' ('generator' | 'async');
METHOD_ANNOTATION: '@' ('generator' | 'async' | 'static');