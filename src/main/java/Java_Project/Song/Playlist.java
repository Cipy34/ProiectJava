package Java_Project.Song;

import Java_Project.User.User;

import java.util.List;

public final class Playlist {
    private final String numePlaylist;
    private List<Song> songs;
    private final User currentuser;
    private final long id;
    private static long nextid = 0;

    public Playlist(String numePlaylist, List<Song> songs, User currentuser) {
        this.numePlaylist = numePlaylist;
        this.songs = songs;
        this.currentuser = currentuser;
        this.id = nextid++;
    }
}
