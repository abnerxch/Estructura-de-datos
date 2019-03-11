package com.company;

 class VariableNode extends ExpNode {

     //ExpNode expNode = new ExpNode() {
         @Override
         double value(double xValue) {
             return xValue;
         }

         @Override
         void printStackCommands() {
             System.out.println("Push X");
         }

         @Override
         void printInfix() {
             System.out.println("x");
         }

         @Override
         ExpNode derivative() {
             return new ConstNode(1);
         }

     //};
}
