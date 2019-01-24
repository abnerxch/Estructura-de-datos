package com.company;

import java.util.Scanner;

public class Main {

    private static int tamaño;
    public int array[] = new int[tamaño];
    int top = -1;

    public void push(int añadido)
    {
        if (top < tamaño - 1) {
            top++;
            array[top] = añadido;
            System.out.println("Elemento " + añadido + " añadido a Stack\n");
            mostrar();
        } else {
            System.out.println("=Stack Overflow=\n");
        }
    }

    public void pop()
    {
        if (top >= 0) {
            top--;
            System.out.println("Pop realizado\n");
            mostrar();
        } else {
            System.out.println("=Stack Underflow=\n");
        }
    }

    public void clear()
    {
        for(int i = 0; i <= array.length; i++)
            top--;
        System.out.println("Array vacío");
    }

    public void mostrar()
    {
        if (top >= 0) {
            System.out.println("Elements in stack :");
            for (int i = 0; i <= top; i++) {
                System.out.println(array[i]);
            }
            System.out.println("\n");
        }
    }

    public static void main(String [] args){
        Scanner reader = new Scanner(System.in);
        int elemento; int opción;


        System.out.println("Ingrese el tamaño del Array");
        tamaño = reader.nextInt();

        Main stack = new Main();

        do {

            System.out.println("Seleccione la opción a realizar");
            System.out.println("1. Push - Añadir");
            System.out.println("2. Pop - Quitar");
            System.out.println("3. Clear - Limpiar");
            System.out.println("0. Salir");
            opción = reader.nextInt();

            switch (opción)
            {
                case 1:
                    System.out.println("Ingrese número");
                    elemento = reader.nextInt();
                    stack.push(elemento);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.clear();
                    break;

                case 0:
                    System.out.println("Bye bye");
                    break;

                default:
                    System.out.println("Ingrese una opción disponible\n");
                    break;
            }

        } while (opción!=0);
    }
}