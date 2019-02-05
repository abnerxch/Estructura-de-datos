package com.company;

public class itemProd extends  Product{

    public itemProd(int number, String fishname, int fishquantity, double fishprice) {

        super(number, fishname, fishquantity, fishprice);

    }


    public double getValue() {

        double inventoryvalue = super.getValue();

        return (inventoryvalue * 1);

    }
}
