package com.company;

public class EulerNode extends ExpNode {

    double value(double eValue) {
        return eValue;
    }

    //@Override
    void printStackCommands() {
        System.out.println("Push e");
    }

    //@Override
    void printInfix() {
        System.out.print("e");
    }

    //@Override
    ExpNode derivative() {
        return new ConstNode('e');
    }
}
