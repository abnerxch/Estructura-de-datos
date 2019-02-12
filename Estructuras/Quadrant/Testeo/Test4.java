import org.junit.Assert;
import org.junit.Test;

public class Test4 {

    @Test
    public void CuadranteCuatro(){
        Quadrant test1 = new Quadrant();

        test1.posiciónX = 9;
        test1.posiciónY = -33;
        test1.determinarCuadrante();

        Assert.assertEquals(4, test1.ubicación);
    }
}
