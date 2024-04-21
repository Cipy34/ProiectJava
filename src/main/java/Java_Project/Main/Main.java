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

        Command au = new Command(users, currentuser, songs, playlists);
//        CSV csv = new CSV(songs);
//        csv.read();
//        for(Song s : songs)
//            System.out.println(s.getSongName());

        String k = au.run();
        while(!k.equals("quit")){
            System.out.println(k);
            k = au.run();
        }

        DbCommand dbc = new DbCommand();
        dbc.resetDataBase();
        System.out.println("Bye!");
    }
}