package Java_Project.DataBaseCommands;

import Java_Project.Main.DBConnection;
import Java_Project.Song.Playlist;
import Java_Project.Song.Song;
import Java_Project.User.User;

import java.sql.SQLException;
import java.sql.Statement;

public final class DbCommand {
    private final Statement statement;

    public DbCommand() throws SQLException {
        this.statement = new DBConnection().connect().createStatement();
    }

    public void insertUser(User user) throws SQLException {
        statement.executeUpdate("INSERT INTO \"User\" VALUES (" + user.getId() + ", '" + user.getUsername() + "', '" + user.getPassword() + "');");
    }

    public void insertSong(Song song) throws SQLException {
        statement.executeUpdate("INSERT INTO \"Song\" VALUES (" + song.getId() + ", '" + song.getSongName() + "', '" + song.getAuthorName() + "', " + song.getYear() + ");");
    }

    public void insertPlaylist(Playlist playlist, User currentuser) throws SQLException {
        statement.executeUpdate("INSERT INTO \"Playlist\" VALUES (" + playlist.getId() + ", '" + playlist.getPlaylistName() + "', '" + currentuser.getId() + "');");
    }

    public void resetDataBase() throws SQLException {
        System.out.println("DataBase has been restarted");
        statement.executeUpdate("DELETE FROM \"User\"");
        statement.executeUpdate("DELETE FROM \"Song\"");
    }
}
