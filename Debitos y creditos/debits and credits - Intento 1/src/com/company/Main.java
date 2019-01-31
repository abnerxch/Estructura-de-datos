package com.company;

import java.util.Scanner;

public class Main extends Transacciones {

    Transacciones trans = new Transacciones();

    public static void main(String[] args) {
	// write your code here

        Scanner lector = new Scanner(System.in);int opcion = 0;
        do {
            System.out.println("1. Débitos");
            int select = lector.nextInt();
            selector(select);
        } while (opcion != 0);
    }

    public static int selector (int opcion)
    {
        switch (opcion)
        {
            case 1:
                Transacciones.makeaCredit(718);
                break;

            case 3:
                break;
        }
        return opcion;
    }

}
