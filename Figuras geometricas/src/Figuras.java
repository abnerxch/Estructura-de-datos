import java.util.Scanner;

public class Figuras {

    Triángulo triángulo = new Triángulo();
    Círculo círculo = new Círculo();
    Rectángulo rectángulo = new Rectángulo();
    public void CalcularAreas (){

        Scanner reader = new Scanner(System.in);

        System.out.println("Seleccione la opción");
        System.out.println("1. Triángulo");
        System.out.println("2. Círculo");
        System.out.println("3. Rectángulo");
        int opción = reader.nextInt();

        menu(opción);

    }

    public void menu(int selección){
        switch (selección){
            case 1: AreaTriángulo(); break;
            case 2: AreaCírculo(); break;
            case 3: AreaRectángulo(); break;
            default: System.out.println("No ingresó una opción válida");
        }
    }

    public void AreaTriángulo(){
        triángulo.Captura();
        triángulo.CalcularArea();
        triángulo.Imprimir();
    }

    public void AreaCírculo(){
        círculo.Captura();
        círculo.CalcularArea();
        círculo.Imprimir();
    }

    public void AreaRectángulo(){
        rectángulo.Captura();
        rectángulo.CalcularArea();
        rectángulo.Imprimir();
    }

}
