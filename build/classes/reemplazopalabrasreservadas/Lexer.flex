package reemplazopalabrasreservadas;
import static reemplazopalabrasreservadas.Token.*;
%% 
%class Lexer
%type Token
L=[a-b]
D=[0-9]

white=[ ,\n]
%{
	public String lexeme;
%}
%%
{white} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return igual;}
"while" {return While;}
"do" {return Do;}
"if" {return If;}
"else" {return Else;}
"+" {return suma;}
{L} {lexeme=yytext(); return Variable;}
{D} {lexeme=yytext(); return Numero;}
"*" {return multiplicacion;}
"-" {return resta;}
"/" {return division;}
.   {return ERROR;}

