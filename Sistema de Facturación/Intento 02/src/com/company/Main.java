package com.company;

public class Main {
    public static final int maximo = 10;

    private static Product product[] = new itemProd[maximo];

    public static void main(String[] args) {
	// write your code here
        buildInventory();
        getInventory();
    }

    public static void buildInventory() {

        // Listado de los productos


        product[0] = new itemProd(0, "Libra de arroz",50, 4.99);

        product[1] = new itemProd(1, "Libra de azucar",100, 5.99);

        product[2] = new itemProd(2, "Libra de frijol",100, 5.50);

        product[3] = new itemProd(3, "Bolsa de café",20, 45.75);

        product[4] = new itemProd(4, "Paquete de chocolate",40, 19.99);

        product[5] = new itemProd(5, "Agua gaseosa",19, 9.99);

        product[6] = new itemProd(6, "Bolsa de fideos",25, 4.99);

        product[7] = new itemProd(7, "Jabón",45, 5.99);

        product[8] = new itemProd(8, "Libra de sal", 30, 2.99);

        product[9] = new itemProd(9, "Pasta dental",25, 12.25);

    }

    // Obtener los detalles del producto

    public static void getInventory() {

        for(int i = 0; i < product.length; i++) {

            System.out.println("SKU:  " + product[i].getNumber());

            System.out.println("Nombre:      " + product[i].getName());

            System.out.println("Cantidad:   " + product[i].getQuantity());

            System.out.println("Precio:    " + product[i].getPrice());

            //System.out.println("Total : " + product[i].getQuantity() * product[i].getPrice());

            System.out.println();

        }

    }
}
