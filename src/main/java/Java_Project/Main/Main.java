package Java_Project.Main;

import Java_Project.Authentification.Authentication;
import Java_Project.Authentification.Command;
import Java_Project.Song.Song;
import Java_Project.SongCommands.CreateSong;
import Java_Project.SongCommands.SongCommands;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
//        List<User> users = new ArrayList<>();
//        List<Song> songs = new ArrayList<>();
//        users.add(new User("Cipy", "123", Role.Authentificated));
//        users.add(new User("Cipy34", "123", Role.Authentificated));
//        users.add(new User("Cipy345", "123", Role.Administrator));
//
//        User currentuser = users.get(0);
//
////        Command au = new Command(users, currentuser);
////        String msg = au.run();
////        if(msg != null)
////            System.out.println(msg);
//
//        Song currentsong = new Song("Tu yo", "Pablo Escobar", 1990, currentuser);
//        SongCommands sc = new CreateSong(songs, currentsong, currentuser);
//        System.out.println(sc.run());
//        System.out.println(songs);

        DBConnection db = new DBConnection();
        Connection connection = db.connect();
        Statement statement = connection.createStatement();
        //int rowsAffected = statement.executeUpdate("INSERT INTO \"User\" (\"UserId\", \"UserName\", \"Password\") VALUES (2, 'test', 'test');");
        //System.out.println(rowsAffected + " row(s) inserted successfully.");
        int rows2Affected = statement.executeUpdate("DELETE FROM \"User\";");
        //System.out.println(rowsAffected + " row(s) inserted successfully.");


        statement.close();
        connection.close();

    }
}
