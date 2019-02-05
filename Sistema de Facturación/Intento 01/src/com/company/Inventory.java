package com.company;

public class Inventory {

    // Máximo de 10 productos

    public static final int maximo = 10;

    private static Product product[] = new itemProd[maximo];



    public static void main(String args[]) {
        buildInventory();
        getInventory();
    }


    public static void buildInventory() {



        // Listado de los productos



        product[0] = new itemProd(0, "Fancy Tailed Guppy",25, 4.99);

        product[1] = new itemProd(1, "Huma Huma Picasso Trigger",2, 35.99);

        product[2] = new itemProd(2, "Black Durgeon Trigger",1, 99.99);

        product[3] = new itemProd(3, "Niger Trigger",2, 45.99);

        product[4] = new itemProd(4, "Jack Dempsey Cichlid",4, 19.99);

        product[5] = new itemProd(5, "Midas Cichlid",1, 69.99);

        product[6] = new itemProd(6, "Neon Tetra",25, 2.99);

        product[7] = new itemProd(7, "Convict Cichlid",2, 15.99);

        product[8] = new itemProd(8, "Oscar", 4, 37.99);

        product[9] = new itemProd(9, "Albino Cory Cat",1, 29.99);

    }

    // Obtener los detalles del producto

    public static void getInventory() {

        for(int i = 0; i < product.length; i++) {

            System.out.println("SKU:  " + product[i].getNumber());

            System.out.println("Nombre:      " + product[i].getName());

            System.out.println("Cantidad:   " + product[i].getQuantity());

            System.out.println("Precio:    " + product[i].getPrice());

            System.out.println("Total : " + product[i].getQuantity() * product[i].getPrice());


            //System.out.println("Restock Fee: " + (product[i].getQuantity() * product[i].getPrice()) * 1);

            System.out.println();

        }

    }

}
