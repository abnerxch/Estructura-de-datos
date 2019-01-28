import org.junit.Assert;
import org.junit.Test;

public class testClear {

    @Test
    public void clearElements(){
        stack clearTest = new stack();
        for(int m=0; m<clearTest.array.length; m++)
            clearTest.pop();
        Assert.assertEquals(-1, clearTest.top);
        //System.out.println("El limpiador funciona");
    }
}
