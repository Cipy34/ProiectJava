package Java_Project.PlaylistCommands;

import Java_Project.Song.Playlist;
import Java_Project.Song.Song;
import Java_Project.SongCommands.SongById;

import java.util.List;

public class Add {

    /**
     * verifica daca exista deja melodia in playlist
     * @param playlists lista de playlist uri
     * @param songs lista de melodii
     * @return
     */

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

    /**
     * Adauga melodii in playlist byName
     * @param playlistName numele playlist ului in care sunt adaugate melodiile
     * @param ids id-urile melodiilor
     * @param songs lista de melodii
     * @param playlists lista de playlist-uri
     * @return
     */

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

    /**
     * Adauga melodii in playlist byId
     * @param playlistId id ul playlist ului in care sunt adaugate melodiile
     * @param ids id-urile melodiilor
     * @param songs lista de melodii
     * @param playlists lista de playlist-uri
     * @return
     */


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
