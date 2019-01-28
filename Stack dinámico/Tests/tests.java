import org.junit.Assert;
import org.junit.Test;

public class tests {

    @Test
    public void pushElements(){
        System.out.println("La prueba");
        stack test = new stack();
        int añadir = 0;
        for (int i = 0; i < 10; i++)
        {
            int elementoAñadir = test.push(añadir);
            añadir++;
        }

        Assert.assertArrayEquals(new int []{1,2,3}, new  int [] {1,2,3});
    }



}
