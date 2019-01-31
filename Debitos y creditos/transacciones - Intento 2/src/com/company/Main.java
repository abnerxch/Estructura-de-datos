package com.company;

import java.util.Scanner;

public class Main {

    transacciones trans = new transacciones();

    Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
	// write your code here

       menuprincipal();

    }

    static  void menuprincipal()
    {
        Scanner lector = new Scanner(System.in);

        int select;
        //do {
            System.out.println("1. Débitos");
            select = lector.nextInt();
            selector(select);
        //} while (select != 0);
    }

    static void selector(int opcion)
    {
        switch (opcion)
        {
            case 1:
                trans.makeCredit(718);
                trans.makeCredit(520);
                trans.makeCredit(613);
                trans.makeCredit(991);
                trans.makeCredit(952);
                trans.makeCredit(123);
                trans.makeCredit(515);
                trans.makeCredit(941);
                trans.makeCredit(304);
                trans.makeCredit(956);
                break;

            case 2:
                trans.totalCredit();
                break;

                default:
                    System.out.println("Bye");
                    break;
        }

    }
}
