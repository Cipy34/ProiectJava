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
import Java_Project.Formats.CSV;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        User currentuser = new User();
        List<User> users = new ArrayList<>();
        List<Song> songs = new ArrayList<>();
        List<Playlist> playlists = new ArrayList<>();
        playlists.add(new Playlist("1", new ArrayList<>(), currentuser));
        playlists.add(new Playlist("21", new ArrayList<>(), currentuser));
        playlists.add(new Playlist("31", new ArrayList<>(), currentuser));
        playlists.add(new Playlist("41", new ArrayList<>(), currentuser));
        playlists.add(new Playlist("51", new ArrayList<>(), currentuser));
        playlists.add(new Playlist("16", new ArrayList<>(), currentuser));
        playlists.add(new Playlist("17", new ArrayList<>(), currentuser));
        playlists.add(new Playlist("18", new ArrayList<>(), currentuser));
        playlists.add(new Playlist("19", new ArrayList<>(), currentuser));
        playlists.add(new Playlist("10", new ArrayList<>(), currentuser));
        playlists.add(new Playlist("11", new ArrayList<>(), currentuser));
        playlists.add(new Playlist("112", new ArrayList<>(), currentuser));
        playlists.add(new Playlist("113", new ArrayList<>(), currentuser));



        Command au = new Command(users, currentuser, songs, playlists);

        String k = au.run();
        while(!k.equals("quit")){
            System.out.println(k);
            k = au.run();
        }

        System.out.println("Bye!");
    }
}