package Java_Project.Formats;

import Java_Project.Song.Song;

import java.util.List;

public class SongsCSV {
    public void readSongs(List<Song> songs){
        CSV csv = new CSV(songs);
        csv.read();
    }
}
