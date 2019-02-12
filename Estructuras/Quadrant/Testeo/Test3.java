import org.junit.Assert;
import org.junit.Test;

public class Test3 {

    @Test
    public void CuadranteTres(){
        Quadrant test1 = new Quadrant();

        test1.posiciónX = -20;
        test1.posiciónY = -1;
        test1.determinarCuadrante();

        Assert.assertEquals(3, test1.ubicación);
    }
}
