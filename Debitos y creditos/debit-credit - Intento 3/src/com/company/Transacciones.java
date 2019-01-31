package com.company;

public class Transacciones {

    double [] creditos = new double[20];
    int contadorCredits = 0 ;
    double totalCredits = 0;

    double [] debits = new  double[20];
    int contadorDebits = 0;
    double totalDebits = 0;
    double promedioDeb;

    double saldo, saldoRestante;
    double numMayor, posicion;

    public void makeaDebit (double newDebit)
    {
        debits[contadorDebits] = newDebit;
        contadorDebits += 1;
        totalDebits += newDebit;
    }

    public void makeaCredit (double newCredit)
    {
        creditos[contadorCredits] = newCredit;
        contadorCredits+=1;
        totalCredits += newCredit;
    }

    /*public void totaldeDebits ()
    {

    }

    public void totaldeCredits ()
    {

    }*/

    public void promedioDebits ()
    {
        promedioDeb = totalDebits / contadorDebits;
    }

    public  void saldoTotal(double saldoRestante)
    {
        saldoRestante = totalCredits - totalDebits;
        return;
    }

    public void debitoGrande ()
    {

        numMayor = debits[0];
        posicion = 0;

        for (int x = 1; x < debits.length; x++)
            if (debits[x] > numMayor)
            {
                numMayor = debits[x];
                posicion = x;
            }
    }

}
