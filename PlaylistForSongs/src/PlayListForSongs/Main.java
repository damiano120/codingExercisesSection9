package PlayListForSongs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Szklanka wody","Bajm");
        album.addSong("Woda", 3.26);
        album.addSong("Woda2", 2.46);
        album.addSong("Woda3", 1.55);
        album.addSong("Woda4", 4.31);
        albums.add(album);

        album = new Album("Jakis album", "Hej");
        album.addSong("Title1", 3.11);
        album.addSong("Title2", 3.16);
        album.addSong("Title3", 4.55);
        album.addSong("Title4", 2.51);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addSongToPlaylist("Title2", playList);
        albums.get(0).addSongToPlaylist("Woda3", playList);
        albums.get(0).addSongToPlaylist("Title1", playList);
        albums.get(1).addSongToPlaylist(3, playList);
        albums.get(1).addSongToPlaylist(2, playList);
        albums.get(1).addSongToPlaylist(4, playList);
    }

    public static play(){

        boolean quit=true;
        while (quit){
            int action;
            switch (action){
                case 0:
                    quit=false;
                    break;
                case 1:
                    next;
                    break;
                case 2:
                    previous;
                    break;
                case 3:
                    replay;
                    break;
            }
        }
    }
}
