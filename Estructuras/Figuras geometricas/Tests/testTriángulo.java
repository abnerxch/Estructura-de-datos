import org.junit.Assert;
import org.junit.Test;

public class testTriángulo {

    @Test
    public void AreaTriánguloTest(){
        Triángulo test = new Triángulo();
        test.baseT = 10;
        test.alturaT = 5;
        test.CalcularArea();
        test.Imprimir();

        //Assert.assertEquals(25, test.areaT);
        Assert.assertEquals("Elemenots coinciden", 25, test.areaT);
    }
}
