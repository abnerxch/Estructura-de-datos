import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;


public class BTree <Key extends Comparable<Key>, Value>{
    private static final int MaxChildren = 4;

    private Node root;
    private int height;
    private int numberOfKeyValues;

    private static  class Node {
        private int numberOfChildren;
        public Entry[] children = new Entry[MaxChildren ];

        private Node (int kChildren ){ //nodo con k Children
            numberOfChildren = kChildren;
        }
    }

    private static class Entry{
        private Comparable keyEntry;
        private final Object valueEntry;
        private BTree.Node next;

        public Entry (Comparable keyEntry, Object valueEntry, BTree.Node next){
            this.keyEntry = keyEntry;
            this.valueEntry = valueEntry;
            this.next = next;
        }
    }

    public  BTree(){
        root = new Node(0);
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return numberOfKeyValues;
    }

    public int height(){
        return height;
    }

    public Value get (Key key){
        if(key == null) throw new IllegalArgumentException("Argumento a get() es NULL");
        return search(root, key, height);
    }

    public Value search (Node xNumberOfNode, Key key, int heightOfNode){
        Entry[] children = xNumberOfNode.children;

        if(heightOfNode == 0){
            for (int posicionJ = 0; posicionJ < xNumberOfNode.numberOfChildren; posicionJ++) {
                if(equalsTo(key, children[posicionJ].keyEntry)) return (Value) children[posicionJ].valueEntry;
            }
        }

        else {
            for (int posicionJ = 0; posicionJ < xNumberOfNode.numberOfChildren; posicionJ++) {
                if (posicionJ +1 == xNumberOfNode.numberOfChildren || lessThan(key, children[posicionJ+1].keyEntry))
                    return search(children[posicionJ].next, key, heightOfNode-1);
            }
        }
        return null;
    }

    public void put (Key keyPut, Value valuePut){
        if(keyPut == null) throw new IllegalArgumentException("Argumento a put() es NULL");
        Node putNode = insert(root, keyPut, valuePut, height);
        numberOfKeyValues++;
        if(putNode == null) return;

        Node putNodeFather = new Node(2);
        putNodeFather.children[0] = new Entry(root.children[0].keyEntry, null, root);
        putNodeFather.children[1] = new Entry(putNode.children[0].keyEntry, null, putNode);
        root = putNodeFather;
        height++;
    }

    private Node insert(Node insertNode, Key insertKey, Value insertValue, int insertHeight){
        int posicionI;
        Entry insertNewNode = new Entry(insertKey, insertValue, null);

        if( insertHeight == 0){
            for (posicionI = 0; posicionI < insertNode.numberOfChildren; posicionI++) {
                if(lessThan(insertKey, insertNode.children[posicionI].keyEntry)) break;
            }
        }

        else {
            for (posicionI = 0; posicionI < insertNode.numberOfChildren; posicionI++) {
                if ((posicionI + 1 == insertNode.numberOfChildren) || lessThan (insertKey, insertNode.children[posicionI + 1].keyEntry)){
                    Node insertNewNodeFather = insert(insertNode.children[posicionI++].next, insertKey, insertValue, insertHeight-1);
                    if(insertNewNodeFather == null) return null;
                    insertNewNode.keyEntry = insertNewNodeFather.children[0].keyEntry;
                    insertNewNode.next = insertNewNodeFather;
                    break;
                }
            }
        }

        for(int posicionK = insertNode.numberOfChildren; posicionK > posicionI; posicionK--){
            insertNode.children[posicionK] = insertNode.children[posicionK-1];
        }
        insertNode.children[posicionI] = insertNewNode;
        insertNode.numberOfChildren++;
        if(insertNode.numberOfChildren < MaxChildren  ) return null;
        else return split(insertNode);
    }

    private Node split(Node nodeToSplit){
        Node newNodeToSplit = new Node(MaxChildren /2);
        nodeToSplit.numberOfChildren = MaxChildren /2;
        for (int posicionL = 0; posicionL < MaxChildren /2; posicionL++) {
            newNodeToSplit.children[posicionL] = nodeToSplit.children[MaxChildren/2+posicionL];
        }
        return newNodeToSplit;
    }

    public String toString(){
        return toString(root, height, "") + "\n";
    }

    private String toString(Node nodeToString, int heightToString, String indent){
        StringBuilder newNodeToString = new StringBuilder();
        Entry[] children = nodeToString.children;

        if(heightToString == 0){
            for (int posicionM = 0; posicionM < nodeToString.numberOfChildren; posicionM++) {
                newNodeToString.append(indent + children[posicionM].keyEntry + " " + children[posicionM].valueEntry + "\n");
            }
        }

        else{
            for (int posicionN =0; posicionN < nodeToString.numberOfChildren; posicionN++){
                if (posicionN > 0) newNodeToString.append(indent + "(" + children[posicionN].keyEntry + ")\n");
                newNodeToString.append(toString(children[posicionN].next, heightToString-1, indent + "      "));
            }
        }
        return newNodeToString.toString();
    }

    private boolean lessThan(Comparable leaf1, Comparable leaf2){
        return leaf1.compareTo(leaf2) < 0;
    }

    private boolean equalsTo(Comparable leaf1, Comparable leaf2){
        return leaf1.compareTo(leaf2) == 0;
    }

    public static void main(String[ ] args) throws IOException  {
        LinkedList linkedlist = new LinkedList();
        String sCadena;
        String filepath = "C:\\Users\\Abner\\IdeaProjects\\B-Tree\\src\\main\\java\\words_alpha.txt";
        BTree<String, String> stringNode = new BTree<String, String>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String sCurrentLine;
            int node = 0;

            while ((sCurrentLine = br.readLine()) != null) {
                stringNode.put(sCurrentLine, "");
                linkedlist.insert(linkedlist, sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stopwatch stopwatch = new Stopwatch();
    }

}
