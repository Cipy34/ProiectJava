package Java_Project.Formats;

import Java_Project.Song.Playlist;
import Java_Project.Song.Song;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSON {
    public void write(String fileName, Playlist playlist) throws IOException {
        JSONObject obj = new JSONObject();
//        obj.put("Playlist Name", "Name");
//        obj.put("Songs", "[[SongName1, AuthorName1, Year1], [SongName2, AuthorName2, Year2], [SongName3, AuthorName3, Year3]]");
        obj.put("Playlist Name", playlist.getPlaylistName());
        String songsJson = "[";
        for(Song song : playlist.getSongs()){
            songsJson += "[";
            songsJson += song.getSongName();
            songsJson += ", ";
            songsJson += song.getAuthorName();
            songsJson += ", ";
            songsJson += song.getYear();
            songsJson += "], ";
        }
        songsJson = songsJson.substring(0, songsJson.length() - 2);
        songsJson += "]";
        obj.put("songs", songsJson);

        FileWriter fw = new FileWriter("D:\\facultate\\an 2\\s2\\java\\ProiectJava\\src\\main\\java\\Java_Project\\ExportedPlaylists\\" + fileName);
        fw.write(obj.toJSONString());
        fw.close();
    }
}
