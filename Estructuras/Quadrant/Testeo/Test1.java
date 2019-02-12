import org.junit.Assert;
import org.junit.Test;

public class Test1 {
    @Test
    public void CuadranteUno(){
        Quadrant test1 = new Quadrant();

        test1.posiciónX = 10;
        test1.posiciónY = 7;
        test1.determinarCuadrante();

        Assert.assertEquals(1, test1.ubicación);
    }
}
