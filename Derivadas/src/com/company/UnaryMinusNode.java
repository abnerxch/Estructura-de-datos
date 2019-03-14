package com.company;

public class UnaryMinusNode extends ExpNode {
    //ExpNode expNode4 = new ExpNode() {
    ExpNode operand;

    UnaryMinusNode (ExpNode operand){
        this.operand = operand;
    }
        //@Override
        double value(double xValue) {
        double neg = operand.value(xValue);
            return -neg;
        }

        //@Override
        void printStackCommands() {
            operand.printStackCommands();
            System.out.println("Unary minus");

        }

        //@Override
        void printInfix() {
            System.out.print("(-");
            operand.printInfix();
            System.out.print(')');

        }

        //@Override
        ExpNode derivative() {
            return new UnaryMinusNode(operand.derivative());
        }
    //}
}
