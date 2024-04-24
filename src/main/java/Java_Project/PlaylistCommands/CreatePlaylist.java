package Java_Project.PlaylistCommands;

import Java_Project.DataBaseCommands.DbCommand;
import Java_Project.Song.Playlist;
import Java_Project.User.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreatePlaylist {

    /**
     * Creeaza un playlist nou si verifica daca exista deja
     * @param playlist playlist ul care trebuie adaugat
     * @param currentuser utilizatorul care doreste adaugarea unui playlist
     * @param playlists lista de playlist uri
     * @return
     * @throws SQLException
     */

    public String run(Playlist playlist, User currentuser, List<Playlist> playlists) throws SQLException {
        String name = playlist.getPlaylistName();
        for(Playlist playlistList : playlists){
            if(playlistList.getPlaylistName().equals(name) && playlistList.getCurrentuser() == currentuser){
                return "You already have a playlist named " + name;
            }
        }

        DbCommand dbc = new DbCommand();
        dbc.insertPlaylist(playlist, currentuser);
        playlists.add(playlist);

        return "Playlist " + name + " was created successfully!";
    }
}
