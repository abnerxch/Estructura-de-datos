package Estructuras;

public class Main {

    public static void main (String [] args){
        HashTable tabla = new HashTable();

        /*for(int i = 0; i < 101; i++){
            try{
                tabla.insertar(i);
            } catch (Exception e) {e.printStackTrace();}
        }

        try {
            tabla.insertar(10);
        } catch (Exception e) {e.printStackTrace();}

        for (Integer i = -1; i <30; i++){
            System.out.println("Buscando " +  i + ": " + tabla.buscar());
        }*/

        for (Integer i = -50; i <= 50; i++){
            tabla.insertar(i);
        }

    }

}
