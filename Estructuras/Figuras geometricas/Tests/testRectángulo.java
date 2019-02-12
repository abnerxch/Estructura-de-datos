import org.junit.Assert;
import org.junit.Test;

public class testRectángulo {

    @Test
    public void AreaRectánguloTest(){
        Rectángulo rectánguloTest = new Rectángulo();

        rectánguloTest.baseR = 10;
        rectánguloTest.alturaR = 5;
        rectánguloTest.CalcularArea();
        rectánguloTest.Imprimir();

        Assert.assertEquals(50, rectánguloTest.areaR);
    }
}
