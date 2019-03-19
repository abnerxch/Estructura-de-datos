import java.io.FileInputStream;
import java.io.IOException;

public class BTree <Key extends Comparable<Key>, Value>{
    private static final int MaxChildren = 4;

    private Node root;
    private int height;
    private int numberOfKeyValues;

    private static  class Node {
        private int numberOfChildren;
        private Entry[] children = new Entry[MaxChildren ];

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
                newNodeToString.append(toString(children[posicionN].next, heightToString-1, indent + "    "));
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
        String sCadena;
        BTree<String, String> stringNode = new BTree<String, String>();

        stringNode.put("www.cs.princeton.edu", "128.112.136.12");
        stringNode.put("www.cs.princeton.edu", "128.112.136.11");
        stringNode.put("www.princeton.edu",    "128.112.128.15");
        stringNode.put("www.simpsons.com",     "209.052.165.60");
        stringNode.put("www.apple.com",        "17.112.152.32");
        stringNode.put("www.yale.edu",         "130.132.143.21");
        stringNode.put("www.amazon.com",       "207.171.182.16");
        stringNode.put("www.ebay.com",         "66.135.192.87");
        stringNode.put("www.cnn.com",          "64.236.16.20");
        stringNode.put("www.google.com",       "216.239.41.99");
        stringNode.put("www.nytimes.com",      "199.239.136.200");
        stringNode.put("www.microsoft.com",    "207.126.99.140");
        stringNode.put("www.dell.com",         "143.166.224.230");
        stringNode.put("www.slashdot.org",     "66.35.250.151");
        stringNode.put("www.espn.com",         "199.181.135.201");
        stringNode.put("www.weather.com",      "63.111.66.11");
        stringNode.put("www.yahoo.com",        "216.109.118.65");


        System.out.println("cs.princeton.edu:  " + stringNode.get("www.cs.princeton.edu"));
        System.out.println("hardvardsucks.com: " + stringNode.get("www.harvardsucks.com"));
        System.out.println("simpsons.com:      " + stringNode.get("www.simpsons.com"));
        System.out.println("apple.com:         " + stringNode.get("www.apple.com"));
        System.out.println("ebay.com:          " + stringNode.get("www.ebay.com"));
        System.out.println("dell.com:          " + stringNode.get("www.dell.com"));
        System.out.println();

        System.out.println("size:    " + stringNode.size());
        System.out.println("height:  " + stringNode.height());
        System.out.println(stringNode);
        System.out.println();

        String filepath = "C:\\Users\\Abner\\IdeaProjects\\B-Tree\\src\\main\\java\\words_alpha.txt";

        /*FileReader fr = new FileReader(filepath);
        BufferedReader bf = new BufferedReader(fr);
        while ((sCadena = bf.readLine())!=null) {
            System.out.println(sCadena);
            st.put(bf.readLine().toString(), "217.109.119.66");//bf.readLine();
            //String txtReader = sCadena;
            //sCadena.toString();
            //st.put(sCadena, "217.109.119.66");
        }*/

        FileInputStream fis = new FileInputStream(filepath);
        byte[] buffer = new byte[50];
        StringBuilder sb = new StringBuilder();
        while (fis.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new byte[50];
        }
        fis.close();

        String content = sb.toString();
        stringNode.put(content, "");

    }



}
