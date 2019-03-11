package com.company;

abstract class ExpNode {

    abstract double value(double xValue);
    abstract void printStackCommands();
    abstract  void printInfix();
    abstract ExpNode derivative();
}
