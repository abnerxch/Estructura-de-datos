import java.util.Scanner;

public class Círculo {
    public float radioC, areaC;
    static final float PI = 3.1416f;

    public float getRadioC(){
        return radioC;
    }

    public void setRadioC(float radioC){
        this.radioC = radioC;
    }

    public float getAreaC(){
        return areaC;
    }

    public void setAreaC(float areaC)
    {
        this.areaC = areaC;
    }

    public void Captura(){
        Scanner reader = new Scanner(System.in);
        radioC = reader.nextInt();

    }

    public  void CalcularArea(){
        areaC =  PI * radioC * radioC;
    }

    public void Imprimir (){
        System.out.println("El área del triángulo es: " + areaC);
    }

}
