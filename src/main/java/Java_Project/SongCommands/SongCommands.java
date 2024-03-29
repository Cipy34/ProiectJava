package Java_Project.SongCommands;

import Java_Project.Song.Song;
import Java_Project.User.User;

import java.util.List;

public abstract class SongCommands {
    protected final List<Song> songs;
    protected final Song currentsong;
    protected final User currentuser;

    protected SongCommands(List<Song> songs, Song currentsong, User currentuser) {
        this.songs = songs;
        this.currentsong = currentsong;
        this.currentuser = currentuser;
    }

    public abstract String run();
}
