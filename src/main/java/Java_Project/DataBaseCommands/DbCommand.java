package Java_Project.DataBaseCommands;

import Java_Project.Main.DBConnection;
import Java_Project.Song.Playlist;
import Java_Project.Song.Song;
import Java_Project.User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class DbCommand {
    private final Connection connection; // Connection field

    public DbCommand() throws SQLException {
        this.connection = new DBConnection().connect(); // Initialize connection
    }

    public void insertUser(User user) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO \"User\" VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        }
    }

    public void insertSong(Song song) throws SQLException {
        String query = "INSERT INTO \"Song\" VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, song.getId());
            preparedStatement.setString(2, song.getSongName());
            preparedStatement.setString(3, song.getAuthorName());
            preparedStatement.setInt(4, song.getYear());
            preparedStatement.executeUpdate();
        }
    }

    public void insertPlaylist(Playlist playlist, User currentUser) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO \"Playlist\" VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, playlist.getId());
            preparedStatement.setString(2, playlist.getPlaylistName());
            preparedStatement.setInt(3, currentUser.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void resetDataBase() throws SQLException {
        System.out.println("Database has been restarted");
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM \"User\"")) {
            preparedStatement.executeUpdate();
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM \"Song\"")) {
            preparedStatement.executeUpdate();
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM \"Playlist\"")) {
            preparedStatement.executeUpdate();
        }
    }
}
