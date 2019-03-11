package com.company;

public class BinOpNode extends ExpNode {
    //ExpNode expNode3 = new ExpNode() {
    char op; //Operador
    ExpNode left; // Expresión para la operación izquierda
    ExpNode right; //Expresión para la operación derecha

    BinOpNode(char op, ExpNode left, ExpNode right){
        this.op = op;
        this.left = left;
        this.right = right;
    }
        @Override
        double value(double xValue) {
            double x = left.value(xValue);
            double y = right.value(xValue);
            switch (op){
                case '+': return x + y;
                case '-': return x - y;
                case '*': return x * y;
                case '/': return x / y;
                default: return Double.NaN;
            }
            //return 0;
        }

        @Override
        void printStackCommands() {
            left.printStackCommands();
            right.printStackCommands();
            System.out.println("Operator " + op);

        }

        @Override
        void printInfix() {
            System.out.println('(');
            left.printInfix();
            System.out.println(" " + op + " ");
            right.printInfix();
            System.out.println(')');
        }

        @Override
        ExpNode derivative() {
            switch (op){
                case '+':
                    return new BinOpNode('+', left.derivative(), right.derivative());
                case '-':
                    return new BinOpNode('-', left.derivative(), right.derivative());
                case '*':
                    return new BinOpNode('+', new BinOpNode('*', left, right.derivative()), new BinOpNode('*', right,left.derivative()));
                case '/':
                    return new BinOpNode('/', new BinOpNode('-', new BinOpNode('*', right, left.derivative()), new BinOpNode('*', left, right.derivative())),new BinOpNode('*', right, right));
                    default: return null;
            }

        }
    //};
}
