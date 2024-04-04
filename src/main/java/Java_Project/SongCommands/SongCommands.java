package Java_Project.SongCommands;

import Java_Project.Song.Song;

import java.sql.SQLException;
import java.util.List;

public abstract class SongCommands {
    protected final List<Song> songs;
    protected final Song currentsong;

    protected SongCommands(List<Song> songs, Song currentsong) {
        this.songs = songs;
        this.currentsong = currentsong;
    }

    public abstract String run() throws SQLException;
}
