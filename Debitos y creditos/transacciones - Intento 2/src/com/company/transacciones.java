package com.company;

import java.util.Scanner;

public class transacciones extends Main {

    Scanner reader = new Scanner(System.in);

    private int nuevoDato;
    private int calcularTotal;

    double [] debits = new double[50];
    double [] credits = new double[50];

    static   void makeCredit(double newCredit)
    {
        int controlCred = 0;
        credits[controlCred] = newCredit;
        controlCred += 1;
    }

    static  void totalCredit()
    {
        double sumaCredit = 0;
        for (int i = 0; i < credits.length; i++)
        {
            sumaCredit += credits[i];

        }
        System.out.println("El total de los créditos es: " + sumaCredit);
        return;
    }

    /*public static int ingresarDato()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese nuevo dato");
        int nuevoDato = reader.nextInt();
        return  nuevoDato;
    }

    public static int sumarDatos()
    {
        System.out.println("Ingrese nuevo dato");
        int nuevoDato = reader.nextInt();
        return sumadelosDatos();
    }*/

}
