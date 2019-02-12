import org.junit.Assert;
import org.junit.Test;

public class Test5 {
    @Test
    public void CuadranteUno(){
        Quadrant test1 = new Quadrant();

        test1.posiciónX = 0;
        test1.posiciónY = 12;
        test1.determinarCuadrante();

        Assert.assertEquals(0, test1.ubicación);
    }
}
