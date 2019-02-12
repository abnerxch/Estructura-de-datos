import java.util.Scanner;

public class Quadrant {
    public int posiciónX, posiciónY;
    public int ubicación;

    public int getPosiciónX (){
        return posiciónX;
    }

    public void setPosiciónX(int posiciónX){
        this.posiciónX = posiciónX;
    }

    public int getPosiciónY(){
        return posiciónY;
    }

    public void setPosiciónY(int posiciónY){
        this.posiciónY = posiciónY;
    }

    public void Ingresar(){
        Scanner reader = new Scanner(System.in);
        posiciónX = reader.nextInt();
        posiciónY = reader.nextInt();
    }

    public void determinarCuadrante(){
        if(posiciónX > 0 && posiciónY > 0)
            CuadranteUno();
        else if (posiciónX < 0 && posiciónY > 0)
            CuadranteDos();
        else if (posiciónX < 0 && posiciónY < 0)
            CuadranteTres();
        else if (posiciónX > 0 && posiciónY < 0)
            CuadranteCuatro();
        else {
            System.out.println("El punto no está en un cuadrante, puede estar en un eje o en el origen");
            ubicación = 0;
        }

    }

    public void CuadranteUno(){
        System.out.println("El punto " + posiciónX + " , " + posiciónY + " está en el Primer cuadrante");
        System.out.println("Primer Cuadrante");
        ubicación = 1;
    }

    public void CuadranteDos(){
        System.out.println("El punto " + posiciónX + " , " + posiciónY + " está en el Segundo cuadrante");
        System.out.println("Segundo Cuadrante");
        ubicación = 2;
    }

    public void CuadranteTres(){
       System.out.println("El punto " + posiciónX + " , " + posiciónY + " está en el Tercer cuadrante");
        System.out.println("Tercer Cuadrante");
        ubicación = 3;
    }

    public void CuadranteCuatro(){
        System.out.println("El punto " + posiciónX + " , " + posiciónY + " está en el Cuarto cuadrante");
        System.out.println("Cuarto Cuadrante");
        ubicación = 4;
    }
}
