import java.util.Random;

public class Reproductor extends PlayList {

    public void openList(Songs head){
        this.head = head;
        this.tail = tail;
        length +=1;
    }

    public void addSong(Songs songs){
        this.tail.setNext(songs);
        songs.setPrevious(this.tail);
        this.tail = songs;
        length++;
    }

     void playNow(){
        /*int contador = 0;
        Random random = new Random();
        Songs reproducir;
        reproducir = random.nextInt((length - 1)+ 1)+1;

        Songs = this.head;

        for (int j = 0; j < reproducir; j++)
        {
            if(playing.getNext() != null)
                playing = playing.getNext();
        }
        if (playing.getNext() != null)
        {
            playing = playing.getNext();
        }


         System.out.println("Sonando:" + playing.getName());
        return;*/

        Random rand = new Random();


        if(length == 0)
        {
            Songs inicio;
            System.out.println("No hay canciones en el reproductor");
            //addSong();
        }
        else {
            int position = rand.nextInt(length);
            Songs reproducir = head;

                for(int i = 0; i  < position; i++)
                {
                    if (reproducir.getNext() != null)
                    {
                        reproducir = reproducir.getNext();
                    }
                }
            System.out.println("Sonando:" + reproducir.getName());
        }

         /*Random random = new Random();
         int position = random.nextInt(length);
         Songs temp = head;
         int counter=0;
         while(counter < position)
         {
             counter++;
             if (temp.getNext() != null)
             {
                 temp = temp.getNext();
             }
         }*/
    }

    public Songs playNext(Songs songs){
        if(songs != tail){
            return songs.getNext();
        }
        else {
            return this.tail = songs;
        }
    }

    public Songs playPrevious(Songs songs){
        if(songs != head){
            return songs.getPrevious();
        }
        else{
            return this.head = songs;
        }
    }

    public void actualList(){
        Songs playing = head;
        for (int i = 0; i <= length; i++)
        {
            System.out.println(i + ". " + playing.getName());
        }
    }
}
