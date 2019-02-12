import org.junit.Assert;
import org.junit.Test;

public class testCírculo {

    @Test
    public void AreaCírculoTest(){
        Círculo círculoTest = new Círculo();
        círculoTest.radioC = 4;
        círculoTest.CalcularArea();
        círculoTest.Imprimir();

        //Assert.assertEquals("Elemenots coinciden", 25, círculoTest.areaC);
        //Assert.assertEquals(50.2656f, círculoTest.areaC);
        //Assert.assertEquals(50.2656, círculoTest.areaC);

    }
}
