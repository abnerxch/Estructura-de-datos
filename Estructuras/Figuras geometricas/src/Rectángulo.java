import java.util.Scanner;

public class Rectángulo {

    public int baseR, alturaR, areaR;

    public int getBaseR()
    {
        return baseR;
    }

    public void setBaseR(int baseR){
        this.baseR = baseR;
    }

    public int getAlturaR(){
        return  alturaR;
    }

    public void setAlturaR(int alturaR)
    {
        this.alturaR = alturaR;
    }

    public void Captura(){
        Scanner reader = new Scanner(System.in);
        baseR = reader.nextInt();
        alturaR = reader.nextInt();

    }

    public  void CalcularArea(){
        areaR =  baseR * alturaR;
    }

    public void Imprimir (){
        System.out.println("El área del triángulo es: " + areaR);
    }
}
