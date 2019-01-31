package com.company;

import java.util.Scanner;

public class Main extends Transacciones{
    Transacciones trans = new  Transacciones();
    static double valorDebt;


    public static void main(String[] args) {
	// write your code here
        mainMenu();

    }

    static void mainMenu()
    {
        Scanner reader = new Scanner(System.in);
        Transacciones trans = new  Transacciones();
        int opcion;

        do {
            System.out.println("\n1. Debits");
            System.out.println("2. Credits");
            System.out.println("3. Total de debits");
            System.out.println("4. Total de credits");
            System.out.println("5. Mostrar saldo");
            System.out.println("6. Promedio de débitos");
            System.out.println("7. Monto de débitos mayor");
            System.out.println("8. Hacer el conteo");
            System.out.println("9. Mostrar todos los débitos y créditos");
            opcion = reader.nextInt();

            switch (opcion)
            {
                case 1:
                    //valorDebt = 25.0;
                    //ingresarDebit(valorDebt);

                    //Añadir más valores
                    trans.makeaDebit(75);
                    trans.makeaDebit(911);
                    trans.makeaDebit(123);
                    trans.makeaDebit(456);
                    trans.makeaDebit(789);
                    trans.makeaDebit(21);
                    trans.makeaDebit(34);
                    trans.makeaDebit(72);
                    trans.makeaDebit(35);
                    trans.makeaDebit(46);
                    break;

                case 2:
                    //Añadir más valores
                    trans.makeaCredit(78);
                    trans.makeaCredit(999);
                    trans.makeaCredit(728);
                    trans.makeaCredit(417);
                    trans.makeaCredit(823);
                    trans.makeaCredit(125);
                    trans.makeaCredit(671);
                    trans.makeaCredit(517);
                    trans.makeaCredit(11);
                    trans.makeaCredit(36);
                    break;

                case 3:
                    System.out.println("El total de débitos es: " + trans.totalDebits);
                    break;

                case 4:
                    System.out.println("El total de créditos es: " + trans.totalCredits);
                    break;

                case 5:
                    trans.saldoTotal(opcion);
                    System.out.println("El saldo es: " + trans.saldoRestante);
                    break;

                case 6:
                    System.out.println("El promedio de los débitos es " + trans.promedioDeb);
                    break;

                case 7:
                    System.out.println("Débito mayor " + trans.numMayor);
                    break;

                case 8:
                    System.out.println("Conteo de debits: " + trans.contadorDebits);
                    System.out.println("Conteo de credits: " + trans.contadorCredits);
                    break;

                case 9:
                    System.out.print("\nLos débitos son: ");
                    for (int i = 0; i < trans.debits.length; i++)
                        System.out.print("[ " + trans.debits[i] + " ]");
                    System.out.print("\nLos créditos son: ");
                    for (int j = 0; j < trans.creditos.length; j++)
                        System.out.print("[ " + trans.creditos[j] + " ]");
                    break;

                case 10:
                    break;

                    default:
                        System.out.print("Bye");
                        break;
            }
        } while (opcion != 0);

    }

    /*static void ingresarDebit()
    {

        trans.makeaDebit(valorDebt);
    }*/
}
