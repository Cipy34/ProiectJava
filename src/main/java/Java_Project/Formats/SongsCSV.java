package Java_Project.Formats;

import Java_Project.Song.Song;

import java.util.List;

public final class SongsCSV {

    /**
    @param songs lista de melodii adaugate in baza de date
     functia citeste un fisier CSV si adauga in lista songs melodiile
     */

    public void readSongs(List<Song> songs){
        CSV csv = new CSV(songs);
        csv.read();
    }
}
