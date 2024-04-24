package Java_Project.BackupDataBase;

import Java_Project.DataBaseCommands.DbCommand;
import Java_Project.Song.Playlist;
import Java_Project.Song.Song;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.sql.SQLException;
import java.util.List;

public final class Backup {

    /**
     * realizeaza backup-ul din baza de date, dupa ce programul este rerulat, citeste toate datele din baza de date si le pune in liste
     * @param songs lista de melodii
     * @param users lista de useri
     * @param playlists lista de playlist-uri
     * @throws SQLException
     */

    public void run(List<Song> songs, List<User> users, List<Playlist> playlists) throws SQLException {
        DbCommand dbc = new DbCommand();
        dbc.selectSongs(songs);
        dbc.selectUsers(users);
        dbc.selectPlaylist(playlists, users);
    }
}
