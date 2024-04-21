package Java_Project.BackupDataBase;

import Java_Project.DataBaseCommands.DbCommand;
import Java_Project.Song.Playlist;
import Java_Project.Song.Song;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.sql.SQLException;
import java.util.List;

public final class Backup {
    public void run(List<Song> songs, List<User> users, List<Playlist> playlists) throws SQLException {
        DbCommand dbc = new DbCommand();
        dbc.selectSongs(songs);
        dbc.selectUsers(users);
        dbc.selectPlaylist(playlists, users);
    }
}
