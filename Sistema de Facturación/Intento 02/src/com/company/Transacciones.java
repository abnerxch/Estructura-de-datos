package com.company;

import java.util.Scanner;

public class Transacciones extends Main {

    public Compra [] nuevacompra = new  Compra[10];
    public Pago [] nuevopago = new Pago[5];

    public static int skuingresado;

    public static void ingresarCompra(Compra c)
    {
        Scanner reader = new Scanner(System.in);
        getInventory();
        for (int a = 0; a < 10; a++)
        {
            System.out.println("Ingrese el SKU que desea adquirir");
            skuingresado = reader.nextInt();
            //nuevacompra[a] = reader.nextInt();

        }


    }

}
