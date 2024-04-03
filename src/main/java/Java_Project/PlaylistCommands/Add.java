package Java_Project.PlaylistCommands;

import Java_Project.Song.Playlist;
import Java_Project.Song.Song;
import Java_Project.SongCommands.SongById;

import java.util.List;

public class Add {
    public boolean duplicates(List<Playlist> playlists, Song song){
        for(Playlist playlist : playlists){
            for(Song csong : playlist.getSongs()){
                if(csong == song)
                    return false;
            }
        }
        return true;
    }

    public boolean duplicates(List<Playlist> playlists, List<Song> songs){
        for(Playlist playlist : playlists){
            for(Song psong : playlist.getSongs()){
                for(Song song : songs){
                    if(psong == song)
                        return false;
                }
            }
        }
        return true;
    }
    public String run(String playlistName, int id, List<Song> songs, List<Playlist> playlists){
        for(Playlist playlist : playlists){
            if(playlist.getPlaylistName().equals(playlistName)){
                SongById sbi = new SongById();
                Song song = sbi.songById(id, songs);
                if(song != null) {
                    if (duplicates(playlists, song)) {
                        playlist.setSongs(song);
                        return "Added " + song.getSongName() + " by " + song.getAuthorName() + " to " + playlist.getPlaylistName();
                    } else
                        return "The song " + song.getSongName() + " by " + song.getAuthorName() + " is already part of " + playlist.getPlaylistName();
                }
            }
        }

        return "The desired playlist does not exist.";
    }

    public String run(String playlistName, List<Integer> ids, List<Song> songs, List<Playlist> playlists){
        for(Playlist playlist : playlists){
            if(playlist.getPlaylistName().equals(playlistName)){
                SongById sbi = new SongById();
                List<Song> currentsongs = sbi.songById(ids, songs);
                if(currentsongs != null){
                    if(duplicates(playlists, currentsongs)){
                        playlist.setSongs(currentsongs);
                        return "Songs have been added";
                    }
                    else{
                        return "A song is already in that playlist. Nothing changed!";
                    }
                }

            }
        }

        return "The desired playlist does not exist.";
    }

    public String run(int playlistId, int id, List<Song> songs, List<Playlist> playlists){
        for(Playlist playlist : playlists){
            if(playlist.getId() == playlistId){
                SongById sbi = new SongById();
                Song song = sbi.songById(id, songs);
                if(song != null) {
                    if (duplicates(playlists, song)) {
                        playlist.setSongs(song);
                        return "Added " + song.getSongName() + " by " + song.getAuthorName() + " to " + playlist.getPlaylistName();
                    } else{
                        return "The song " + song.getSongName() + " by " + song.getAuthorName() + " is already part of " + playlist.getPlaylistName();
                    }
                }
            }
        }

        return "The desired playlist does not exist.";
    }

    public String run(int playlistId, List<Integer> ids, List<Song> songs, List<Playlist> playlists){
        for(Playlist playlist : playlists){
            if(playlist.getId() == playlistId){
                SongById sbi = new SongById();
                List<Song> currentsongs = sbi.songById(ids, songs);
                if(currentsongs != null){
                    if(duplicates(playlists, currentsongs)){
                        playlist.setSongs(currentsongs);
                        return "Songs have been added";
                    }
                    else{
                        return "A song is already in that playlist. Nothing changed!";
                    }
                }
            }
        }
        return "The desired playlist does not exist.";
    }
}
