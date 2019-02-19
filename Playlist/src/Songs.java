public class Songs extends Reproductor {

    public Songs next;
    public Songs previous;
    public String name;

    public void setNext(Songs next){
        this.next = next;
    }

    public Songs getNext(){
        return this.next;
    }

    public void setPrevious(Songs previous){
        this.previous = previous;
    }

    public Songs getPrevious(){
        return  this.previous;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
