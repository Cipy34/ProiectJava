package Java_Project.Main;

import Java_Project.Authentification.Authentication;
import Java_Project.Authentification.Command;
import Java_Project.Authentification.Register;
import Java_Project.DataBaseCommands.DbCommand;
import Java_Project.Song.Playlist;
import Java_Project.Song.Song;
import Java_Project.SongCommands.CreateSong;
import Java_Project.SongCommands.SongById;
import Java_Project.SongCommands.SongCommands;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        List<User> users = new ArrayList<>();
        List<Song> songs = new ArrayList<>();
        users.add(new User("Cipy", "123", Role.Authentificated));
        users.add(new User("Cipy34", "123", Role.Authentificated));
        users.add(new User("Cipy", "123", Role.Administrator));
        songs.add(new Song("Tu yo", "Pablo Escobar", 1990));
        songs.add(new Song("Test", "test", 1990));

        Playlist playlist = new Playlist("Test", new ArrayList<>(), users.get(0));
        SongById sbi = new SongById();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(0);
        List<Song> ls = sbi.songById(l, songs);
        System.out.println(ls);
//        DbCommand dbc = new DbCommand();
//        dbc.resetDataBase();
//        User currentuser = new User();
//        Register au = new Register(users, currentuser, "Cipy1", "123");
//        System.out.println(au.run());
        //dbc.insertSong(currentsong);
        //dbc.insertUser(users.get(2));
        //dbc.resetDataBase();
//
//        User currentuser = users.get(0);
//
////        Command au = new Command(users, currentuser);
////        String msg = au.run();
////        if(msg != null)
////            System.out.println(msg);
//
//        SongCommands sc = new CreateSong(songs, currentsong);
//        System.out.println(sc.run());
//        System.out.println(songs);
    }
}
