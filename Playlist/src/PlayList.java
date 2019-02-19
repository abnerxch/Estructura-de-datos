public class PlayList {

    public Songs head;
    public Songs tail;
    public int length = 0;

    public void setHead(Songs head){
        this.head = head;
    }

    public Songs getHead(){
        return this.head;
    }

    public void setTail(Songs tail){
        this.tail = tail;
    }

    public Songs getTail(){
        return this.tail;
    }

    public int getLength(){
        return this.length;
    }

}
