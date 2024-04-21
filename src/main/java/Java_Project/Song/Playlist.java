package Java_Project.Song;

import Java_Project.User.User;

import java.util.ArrayList;
import java.util.List;

public final class Playlist {
    private final String playlistName;
    private final List<Song> songs;
    private User currentuser;
    private final int id;
    private static int nextid = 0;

    public Playlist(String playlistName, int userId, List<User> users){
        this.playlistName = playlistName;
        for(User user : users){
            if(user.getId() == userId){
                this.currentuser = user;
                break;
            }
        }
        this.songs = new ArrayList<>();
        this.id = nextid++;
    }

    public Playlist(String playlistName, User currentuser){
        this.playlistName = playlistName;
        this.currentuser = currentuser;
        this.songs = new ArrayList<>();
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

    public List<Song> getSongs(){
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs.addAll(songs);
    }

    public void setSongs(Song song){
        this.songs.add(song);
    }
}
