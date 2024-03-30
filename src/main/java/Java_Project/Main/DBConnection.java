package Java_Project.Main;

import java.sql.*;

public final class DBConnection {
    private final String url;
    private final String username;
    private final String password;

    public DBConnection() {
        this.url = "jdbc:postgresql://localhost:5432/JavaProjectDB";
        this.username = "postgres";
        this.password = "ciprian";
    }

    public Connection connect(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to PostgreSQL database!");
            return connection;
        } catch (SQLException e) {
            throw new Error("Connection failure.");
        }
    }
}
