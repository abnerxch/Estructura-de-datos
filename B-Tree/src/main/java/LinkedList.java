public class LinkedList {

    Node head;

    static class Node {
        String data;
        Node next;
        Node(String dataNode){
            data = dataNode;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, String data){
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        }else{
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }

        return list;
    }

    public boolean search(Node head, String x)
    {
        Node current = head;
        while (current != null)
        {
            if (current.data.equals(x))
                return true;
            current = current.next;
        }
        return false;
    }

    public static void printList(LinkedList list){
        Node currentNode = list.head;
        System.out.print("LinkedList: ");
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }
}