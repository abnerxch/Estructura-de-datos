package com.company;
import javafx.css.CssParser;
import java.util.Scanner;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static String ecuacion;
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) throws ParseError {
	// write your code here
        while(true){
            //System.out.println("Ingrese una ecuación o Enter para salir");
            CustomV1.TextIO.putln("Ingrese una ecuación o Enter para salir");
            CustomV1.TextIO.put("\n? ");
            /*ecuacion = reader.next();
            String [] arrayEcuacion = ecuacion.split("");
            for(int i = 0; i < arrayEcuacion.length; i++)
                System.out.println(arrayEcuacion[i]);*/
            skipBlanks();

            if(CustomV1.TextIO.peek() == '\n')
                break;
            try{
                ExpNode exp = expressionTree();
                skipBlanks();
                if(CustomV1.TextIO.peek() != '\n')
                    throw new ParseError("Datos adicionales después del final de la expresión");
                ExpNode deriv = exp.derivative();
                CustomV1.TextIO.getln();
                deriv.printStackCommands();
                CustomV1.TextIO.put("\nUna versión completa de la derivada es: ");
                System.out.print("");
                CustomV1.TextIO.put(" ");
                deriv.printInfix();
                CustomV1.TextIO.putln();
            }
            catch (ParseError e){
                System.out.println("\nError al ingresar: " + e.getMessage());
                System.out.println("Descartando ingreso: " + CustomV1.TextIO.getln());
            }
        }

        System.out.println("Calculadora apagada");
    }

    static void skipBlanks(){
        //while (a)
        while (CustomV1.TextIO.peek() == ' ' || CustomV1.TextIO.peek() == '\t')
            CustomV1.TextIO.getAnyChar();
    }

    static ExpNode expressionTree() throws ParseError{
        skipBlanks();
        boolean negative;
        negative = false;
        if(CustomV1.TextIO.peek() == '-'){
            CustomV1.TextIO.getAnyChar();
            negative = true;
        }
        ExpNode exp;
        exp = termTree();
        if (negative)
            exp = new UnaryMinusNode(exp);
        skipBlanks();

        while (CustomV1.TextIO.peek() == '+' || CustomV1.TextIO.peek() == '-'){
            char op = CustomV1.TextIO.getAnyChar();
            ExpNode nextTerm = termTree();
            skipBlanks();
        }
        return exp;
    }

    static ExpNode termTree() throws ParseError{
        skipBlanks();
        ExpNode term;
        term = factorTree();
        skipBlanks();
        while (CustomV1.TextIO.peek() == '*' || CustomV1.TextIO.peek() == '/' || CustomV1.TextIO.peek() == '^' || CustomV1.TextIO.peek() == '>'){
            char op = CustomV1.TextIO.getAnyChar();
            ExpNode nextFactor = factorTree();
            term = new BinOpNode(op, term, nextFactor);
            skipBlanks();
        }
        return term;
    }

    static ExpNode factorTree() throws ParseError {
        skipBlanks();
        char ch = CustomV1.TextIO.peek();
        if(Character.isDigit(ch)){
            double num = CustomV1.TextIO.getDouble();
            return  new ConstNode(num);
        }
        else if (ch == 'x' || ch == 'X'){
            CustomV1.TextIO.getAnyChar();
            return new VariableNode();
        }

        else if(ch == 'e' || ch == 'E'){
            CustomV1.TextIO.getAnyChar();
            return new EulerNode();
        }

        else if (ch == '('){
            CustomV1.TextIO.getAnyChar();
            ExpNode exp = expressionTree();
            skipBlanks();
            if(CustomV1.TextIO.peek() != ')')
                throw new ParseError("Falta paréntesis derecho");
            CustomV1.TextIO.getAnyChar();
            return exp;
        }

        else if(ch == '\n')
            throw new ParseError("Fin de línea encontrada a mitad de la expresión");
        else if (ch == ')')
            throw new ParseError("Paréntesis derecho de más");
        else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
            throw new ParseError("Operador fuera de lugar");
        else
            throw new ParseError("Carácter inesperado \"" + ch + "\" encontrado");
    }
}
