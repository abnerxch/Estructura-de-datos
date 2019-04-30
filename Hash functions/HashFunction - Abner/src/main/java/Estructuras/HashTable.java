package Estructuras;
import java.util.Random;

public class HashTable {
    Random rand = new Random();

    private final Integer size = 13;

    public HashTable(){

    }

    private Integer hash (Integer k){
        Integer key = 0;
        Integer positive;
        if(k < 0)
            positive = k * -1;
        else positive = k;

        //Integer positive = k * -1;
        Integer operator2 = positive + size;
        Integer operator1 = (positive * 5381) + size;

        //key = (Math.abs(k) % size) ;
        //position = (Math.abs(k) % size) * (rand.nextInt(10));
        //Integer key = 0;

        if(operator1 > operator2){
            key = operator1 * operator2;
        }
        else {
            key = operator2 % operator1;
        }
        return key;
    }

    public Integer buscar (){
        return null;
    }

    public void insertar (Integer k) /*throws Exception*/ {
        String hex = Integer.toHexString(hash(k));
        System.out.println(k + " tiene el hash -> " + hex);

    }

    public void borrar (Integer k){

    }
}
