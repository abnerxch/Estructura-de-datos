package com.company;

public class Product {

    private String name = "";

    private int number = 0;

    private double price = 0;

    private int quantity = 0;



    // Constructor

    public Product(int number, String name, int quantity, double price) {

        this.number = number;

        this.name = name;

        this.quantity = quantity;

        this.price = price;

    }



    // Acceso público a los métodos

    public String getName() { return name; }

    public int getNumber() { return number; }

    public double getPrice() { return price; }

    public int getQuantity() { return quantity; }

    // Obtener el valor del producto

    public double getValue() {

        return (double) quantity * price;

    }

}
