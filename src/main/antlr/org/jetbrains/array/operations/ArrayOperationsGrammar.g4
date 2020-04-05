grammar ArrayOperationsGrammar;

@header {
package org.jetbrains.array.operations;
}

call_chain
    : call
    | call NEXT call_chain
    ;

call
    : map_call
    | filter_call
    ;

map_call
    : MAP LEFT_CURLY expr RIGHT_CURLY
    ;

filter_call
    : FILTER LEFT_CURLY expr RIGHT_CURLY
    ;

expr
    : ELEMENT
    | NUMBER
    | binary_expr
    ;

binary_expr
    : LEFT_BR expr WHITESPACE binary_operation WHITESPACE expr RIGHT_BR
    ;

binary_operation
    : PLUS
    | MINUS
    | MULT
    | GREATER
    | LESS
    | EQUALS
    | AND
    | OR
    ;

NUMBER
    : '0'
    | '-'? [1-9] DIGIT*
    ;

DIGIT
    : [0-9]
    ;

WHITESPACE
    : ' '
    ;

//WS
//    : [ \t\r\n]+ -> skip
//    ;

LEFT_BR
    : '('
    ;

RIGHT_BR
    : ')'
    ;

LEFT_CURLY
    : '{'
    ;

RIGHT_CURLY
    : '}'
    ;

NEXT
    : '%>%'
    ;

MAP
    : 'map'
    ;

FILTER
    : 'filter'
    ;

ELEMENT
    : 'element'
    ;

PLUS
    : '+'
    ;

MINUS
    : '-'
    ;

MULT
    : '*'
    ;

GREATER
    : '>'
    ;

LESS
    : '<'
    ;

EQUALS
    : '='
    ;

AND
    : '&'
    ;

OR
    : '|'
    ;
