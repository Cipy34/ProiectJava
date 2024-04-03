package Java_Project.PlaylistCommands;

import Java_Project.DataBaseCommands.DbCommand;
import Java_Project.Song.Playlist;
import Java_Project.User.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreatePlaylist {
    public String run(String name, User currentuser, List<Playlist> playlists) throws SQLException {
        for(Playlist playlistList : playlists){
            if(playlistList.getPlaylistName().equals(name) && playlistList.getCurrentuser() == currentuser){
                return "You already have a playlist named " + name;
            }
        }

        Playlist p = new Playlist(name, new ArrayList<>(), currentuser);
        DbCommand dbc = new DbCommand();
        dbc.insertPlaylist(p, currentuser);
        playlists.add(p);

        return "Playlist " + name + " was created successfully!";
    }
}
