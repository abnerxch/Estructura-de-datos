import org.junit.Assert;
import org.junit.Test;

public class Test2 {
    @Test
    public void CuadranteDos(){
        Quadrant test1 = new Quadrant();

        test1.posiciónX = -1;
        test1.posiciónY = 79;
        test1.determinarCuadrante();

        Assert.assertEquals(2, test1.ubicación);
    }
}
