import org.testng.annotations.Test;

public class TestLinkedList {

    @Test (groups = {"All"})
    public void test1(){
        LinkedList linkedList = new LinkedList();
        linkedList.search(linkedList.head, "0");
    }
}
