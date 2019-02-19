import java.util.Scanner;

public class Usuario {
    //public PlayList reproduccion = new PlayList();
    Scanner reader = new Scanner(System.in);

    Songs songs = new Songs();
    PlayList playList = new PlayList();
    Reproductor reproductor = new Reproductor();
    public static Songs nowPlaying;

    public void mainMenu(){

        int opcion;

        do{
            Scanner reader = new Scanner(System.in);
            System.out.println("Ingrese la opción que desea realizar");
            System.out.println("1. Añadir canción");
            System.out.println("2. Reproducir ahora");
            System.out.println("3. Reproducir siguiente");
            System.out.println("4. Reproducir anterior");
            System.out.println("5. Mostrar lista de reporoducción");
            System.out.println("0. Salir");
            opcion = reader.nextInt();

            switch (opcion){
                case 1: añadirSong(); break;
                case 2: reproducirAhora(); break;
                case 3: reproducirSiguiente(); break;
                case 4: reproducirAnterior(); break;
                case 5: imprimir(); break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);

    }

    public void añadirSong(){
        System.out.println("Ingrese el nombre");
        String nombre = reader.next();
        songs.setName(nombre);
        if(playList.length == 0){
            reproductor.openList(songs);
        }
        else{
            reproductor.addSong(songs);
        }
    }

    public void reproducirAhora(){
        if(playList.length == 0)
            System.out.println("La lista está vacía");
        else{
            reproductor.playNow();

        }
    }

    public void reproducirSiguiente(){
        nowPlaying = reproductor.playNext(nowPlaying);
        System.out.println("Sonando:" + nowPlaying.getName());
    }

    public void reproducirAnterior(){
        nowPlaying = reproductor.playPrevious(nowPlaying);
        System.out.println("Sonando:" + nowPlaying.getName());
    }

    public void imprimir(){
        reproductor.actualList();
    }
}
