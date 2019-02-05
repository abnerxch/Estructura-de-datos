package com.company;

public class itemProd extends Product {
    public itemProd(int number, String prodcutname, int productquantity, double productprice) {

        super(number, prodcutname, productquantity, productprice);

    }


    public double getValue() {

        double inventoryvalue = super.getValue();

        return (inventoryvalue * 1);

    }
}
