package Estructuras;

public class HashTable {

    private final Integer size = 13;

    public HashTable(){

    }

    private Integer hash (Integer k){
        Integer key = 0;
        key = Math.abs(k) % size;
        return key;
    }

    public Integer buscar (){
        return null;
    }

    public void insertar (Integer k) /*throws Exception*/ {
        System.out.println(k + " tiene el hash -> " + hash(k));

    }

    public void borrar (Integer k){

    }
}
