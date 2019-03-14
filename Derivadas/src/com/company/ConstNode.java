package com.company;

class ConstNode extends ExpNode{
    double number;
    ConstNode (double val){
        number = val;
    }
    //ExpNode expNode2 = new ExpNode() {
        //@Override
        double value(double xValue) {
            return number;
        }

        //@Override
        void printStackCommands() {
            System.out.println("Push " + number);
        }

        //@Override
        void printInfix() {
            System.out.print(number);

        }

        //@Override
        ExpNode derivative() {
            return new ConstNode(0);
        }
    //}
}
