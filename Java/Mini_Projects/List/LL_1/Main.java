package Java.Mini_Projects.List.LL_1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums=new ArrayList<>();
    public static void main(String[] args) {

        Album a1=new Album("Hindi","Neha");
        a1.addSong("Yara",3.2);
        a1.addSong("Tere bina",2.6);
        a1.addSong("Chaya",3.5);
        albums.add(a1);

        Album a2=new Album("English","Justin Birbal");
        a2.addSong("Sorry",2.8);
        a2.addSong("Stay",2.8);
        a2.addSong("Baby",2.8);
        albums.add(a2);

        LinkedList<Song> playList=new LinkedList<Song>();
        albums.get(0).addToPlaylist("Yara",playList);
        albums.get(0).addToPlaylist(2,playList);
        albums.get(1).addToPlaylist("Sorry",playList);
        albums.get(1).addToPlaylist(3,playList);

        play(playList);

    }
    public static void play(LinkedList<Song> playList){
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> it=playList.listIterator();
        if(playList.size()==0){
            System.out.println("No songs in playlist");
        }else{
            System.out.println("Now playing "+it.next().toString());
        }
        printMenu();
        while(!quit){
            int action=sc.nextInt();
            sc.nextLine();
            switch(action){
                case 0:
                    System.out.println("Playlist complete");
                    quit=true;
                    break;
                case 1:
                    if(!forward){
                        if(it.hasNext()){
                            it.next();
                        }
                        forward=true;
                    }
                    if(it.hasNext()){
                        System.out.println("Now playing "+it.next());
                    }
                    break;
                case 2:
                    if(forward){
                        if(it.hasPrevious()){
                            it.previous();
                        }
                        forward=false;
                    }
                    if(it.hasPrevious()){
                        System.out.println("Now playing "+it.previous());
                    }
                    break;
                case 3:
                    if(it.hasPrevious()){
                        it.previous();
                        System.out.println("Now playing "+it.next());
                    } else{
                        it.next();
                        System.out.println("Now playing "+it.previous());
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0){
                        it.remove();
                        if(it.hasNext()){
                            System.out.println("Now playing "+it.next());
                        }
                        else if(it.hasPrevious()){
                            System.out.println("Now playing "+it.previous());
                        }
                    }
            }
        }
    }
    public static void printList(LinkedList<Song> playList){
        System.out.println("__________________________________________________________");
        for(Song s: playList){
            System.out.println(s.toString());
        }
        System.out.println("__________________________________________________________");
    }
    public static void printMenu(){
        System.out.println("__________________________________________________________");
        System.out.println("""
                1 - to next song
                2 - to previous song
                3 - replay this song
                4 - print playlist
                5 - print Menu
                6 - delete current song from playlist
                0 - exit""");
        System.out.println("__________________________________________________________");
        System.out.print("select : ");
    }
}
