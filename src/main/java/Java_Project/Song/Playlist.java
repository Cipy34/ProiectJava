package Java_Project.Song;

import Java_Project.User.User;

import java.util.List;

public final class Playlist {
    private final String playlistName;
    private List<Song> songs;
    private final User currentuser;
    private final int id;
    private static int nextid = 0;

    public Playlist(String playlistName, List<Song> songs, User currentuser) {
        this.playlistName = playlistName;
        this.songs = songs;
        this.currentuser = currentuser;
        this.id = nextid++;
    }

    public String getPlaylistName(){
        return playlistName;
    }

    public int getId(){
        return id;
    }

    public User getCurrentuser(){
        return currentuser;
    }

    public void setSongs(List<Song> songs) {
        for(Song song : songs){
            this.songs.add(song);
        }
    }

    public void setSongs(Song song){
        this.songs.add(song);
    }
}
