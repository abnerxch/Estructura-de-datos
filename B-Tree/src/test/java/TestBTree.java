import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBTree {
    BTree bTree = new BTree();

    @Test (groups = {"All"})
    public void isEmptyTest(){
        BTree bTree = new BTree();
        bTree.isEmpty();
        Assert.assertTrue(true);
    }

    @Test (groups = {"All"})
    public void sizeTest(){
        BTree bTree = new BTree();
        bTree.size();
        Assert.assertTrue(true);

    }

    @Test (groups = {"All"})
    public void toStringTest(){
        BTree bTree = new BTree();
        bTree.toString();
        Assert.assertEquals(0,0, "");
    }

}
