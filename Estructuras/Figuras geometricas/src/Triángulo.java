import java.util.Scanner;

public class Triángulo {

    public int baseT, alturaT, areaT;

    public int getBaseT(){
        return baseT;
    }

    public void setBaseT(int baseT){
        this.baseT = baseT;
    }

    public int getAlturaT(){
        return alturaT;
    }

    public void setAlturaT(int alturaT){
        this.alturaT = alturaT;
    }

    public int getAreaT(){
        return baseT;
    }

    public void setAreaT(int areaT){
        this.areaT = areaT;
    }

    public void Captura(){
        Scanner reader = new Scanner(System.in);
        baseT = reader.nextInt();
        alturaT = reader.nextInt();
    }

    public  void CalcularArea(){
        areaT = (baseT * alturaT)/2;
    }

    public void Imprimir (){
        System.out.println("El área del triángulo es: " + areaT);
    }
}
