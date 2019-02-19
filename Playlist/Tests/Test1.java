import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class Test1 {
    Reproductor reproductor = new Reproductor();
    @Test
    public void empezar(){

        Songs songs = new Songs();
        int lengthI = reproductor.getLength();
        reproductor.openList(songs);
        int lengthF = reproductor.getLength();
        Assert.assertEquals(lengthF>lengthI, lengthF>lengthI);
    }


    @Test
    public void reproducirAhoraTest(){
        Songs songs = new Songs();
        int lengthI = reproductor.getLength();
        reproductor.playNow();
        int lengthF = reproductor.getLength();
        Assert.assertEquals(lengthF>lengthI, lengthF>lengthI);
    }


    @Test
    public void PlayPreviousTest()
    {
        Songs previous = reproductor.playPrevious(reproductor.getHead());
        Assert.assertEquals(previous, reproductor.getHead());
    }
    @Test
    public void PlayNextTest()
    {
        Songs next = reproductor.playNext(reproductor.getTail());
        Assert.assertEquals(next, reproductor.getTail());
    }


}
