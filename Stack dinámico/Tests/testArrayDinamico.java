import org.junit.Assert;
import org.junit.Test;

public class testArrayDinamico {

    @Test
    public void arrayDinamico(){
        System.out.println("La prueba");
        stack dinamico = new stack();
        int añadir = 0;
        for (int i = 0; i < 13; i++)
        {
            int elementoAñadir = dinamico.push(añadir);
            añadir++;
        }

        Assert.assertArrayEquals(new int []{1,2,3}, new  int [] {1,2,3});
    }

}
