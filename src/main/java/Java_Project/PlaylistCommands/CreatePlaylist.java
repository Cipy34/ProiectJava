package Java_Project.PlaylistCommands;

import Java_Project.DataBaseCommands.DbCommand;
import Java_Project.Song.Playlist;
import Java_Project.User.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreatePlaylist {
    public void createPlaylist(String name, User currentuser, List<Playlist> playlistLists) throws SQLException {
        for(Playlist playlistList : playlistLists){
            if(playlistList.getPlaylistName().equals(name) && playlistList.getCurrentuser() == currentuser){
                System.out.println("You already have a playlist named " + name);
                return;
            }
        }

        Playlist p = new Playlist(name, new ArrayList<>(), currentuser);
        DbCommand dbc = new DbCommand();
        dbc.insertPlaylist(p, currentuser);
        playlistLists.add(p);
        System.out.println("Playlist " + name + " was created successfully!");
    }
}
