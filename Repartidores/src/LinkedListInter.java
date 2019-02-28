import java.util.LinkedList;

public class LinkedListInter {
    LinkedList theList;
    Node current;
    Node preceding;
    Node head;

    public void insertAtStart(int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void insert(int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(head==null)
        {
            head = node;
        }
        else
        {
            Node n = head;
            while(n.next!=null)
            {
                n = n.next;
            }
            n.next =  node;
        }

    }

    public void goFirst(){

    }

    public void isOnList(){

    }

    public Node getCurrent(){
        return current;
    }

    public void advance(){

    }

    public void find(){

    }

    public void equals(){

    }


}


/*
itrEmpleadosPorNss.goFirst();
        while ( (itrEmpleadosPorNss.isOnList()) && !enc ) {
            emp = (Empleado) itrEmpleadosPorNss.getCurrent();
            if (emp.getNss().compareTo(nuevo.getNss())<0) {
                empAnt = emp;
                itrEmpleadosPorNss.advance();
 */
