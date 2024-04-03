package Java_Project.PlaylistCommands;

import Java_Project.Song.Playlist;
import Java_Project.Song.Song;
import Java_Project.SongCommands.SongById;

import java.util.List;

public class Add {
    public void addByName(String playlistName, int id, List<Song> songs, List<Playlist> playlists){
        for(Playlist playlist : playlists){
            if(playlist.getPlaylistName().equals(playlistName)){
                SongById sbi = new SongById();
                Song song = sbi.songById(id, songs);
                if(song != null)
                    playlist.setSongs(song);
                return;
            }
        }
    }

    public void addByName(String playlistName, List<Integer> ids, List<Song> songs, List<Playlist> playlists){
        for(Playlist playlist : playlists){
            if(playlist.getPlaylistName().equals(playlistName)){
                SongById sbi = new SongById();
                List<Song> currentsongs = sbi.songById(ids, songs);
                if(currentsongs != null)
                    playlist.setSongs(currentsongs);
                return;
            }
        }
    }

    public void addByName(int playlistId, int id, List<Song> songs, List<Playlist> playlists){
        for(Playlist playlist : playlists){
            if(playlist.getId() == playlistId){
                SongById sbi = new SongById();
                Song song = sbi.songById(id, songs);
                if(song != null)
                    playlist.setSongs(song);
                return;
            }
        }
    }

    public void addById(int playlistId, List<Integer> ids, List<Song> songs, List<Playlist> playlists){
        for(Playlist playlist : playlists){
            if(playlist.getId() == playlistId){
                SongById sbi = new SongById();
                List<Song> currentsongs = sbi.songById(ids, songs);
                if(currentsongs != null)
                    playlist.setSongs(currentsongs);
                return;
            }
        }
    }
}
