package Java_Project.Authentification;

import Java_Project.PlaylistCommands.Add;
import Java_Project.PlaylistCommands.CreatePlaylist;
import Java_Project.Song.Playlist;
import Java_Project.Song.Song;
import Java_Project.SongCommands.CreateSong;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Command extends Authentication{
    private List<Song> songs;
    private List<Playlist> playlists;
    public Command(List<User> users, User currentuser, List<Song> songs, List<Playlist> playlists) {
        super(users, currentuser);
        this.songs = songs;
        this.playlists = playlists;
    }

    @Override
    public String run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] commands = line.split("\\s+");
        String command = commands[0].toLowerCase();
        String username, password;

        if(command.equals("quit"))
            return "quit";

        switch (command){
            case "login" -> {
                if(currentuser.getRole() != Role.Anonymous)
                    return "You do not have the permission to use this!";

                if(commands.length != 3)
                    return "Invalid number of arguments!";

                username = commands[1];
                password = commands[2];
                Login l = new Login(users, currentuser, username, password);
                System.out.println(l.run());
                return "";
            }

            case "register" -> {
                if(currentuser.getRole() != Role.Anonymous)
                    return "You do not have the permission to use this!";

                if(commands.length != 3)
                    return "Invalid number of arguments!";

                username = commands[1];
                password = commands[2];
                Register r = new Register(users, currentuser, username, password);
                System.out.println(r.run());
                Login l = new Login(users, currentuser, username, password);
                l.run();
                return "";
            }

            case "promote" -> {
                if(currentuser.getRole() != Role.Administrator)
                    return "You do not have the permission to use this!";

                if(commands.length != 2)
                    return "Invalid number of arguments!";

                username = commands[1];
                Promote p = new Promote(users, currentuser, username);
                System.out.println(p.run());
                return "";
            }

            case "logout" -> {
                if(currentuser.getRole() == Role.Anonymous)
                    return "You do not have the permission to use this!";

                if(commands.length != 1)
                    return "Invalid number of arguments!";

                Logout l = new Logout(users, currentuser);
                System.out.println(l.run());
                return "";
            }

            case "create" -> {
                if(commands[1].equalsIgnoreCase("song")){
                    if(currentuser.getRole() != Role.Administrator)
                        return "You do not have the permission to use this!";

                    if(commands.length != 5)
                        return "Invalid number of arguments!";

                    String name = commands[2];
                    String authorName = commands[3];
                    int year = Integer.parseInt(commands[4]);

                    Song song = new Song(name, authorName, year);
                    CreateSong cs = new CreateSong(songs, song);
                    System.out.println(cs.run());
                }
                else if(commands[1].equalsIgnoreCase("playlist")){
                    if(currentuser.getRole() != Role.Administrator)
                        return "You do not have the permission to use this!";

                    if(commands.length != 3)
                        return "Invalid number of arguments!";

                    String name = commands[2];

                    Playlist playlist = new Playlist(name, new ArrayList<>(), currentuser);
                    CreatePlaylist cp = new CreatePlaylist();
                    System.out.println(cp.run(name, currentuser, playlists));
                }
                else{
                    return "Unknown command!";
                }

                return "";
            }

            case "add" -> {
                String playlistName;
                int playlistId;
                int songId;
                List<Integer> songIds = new ArrayList<>();
                Add add = new Add();

                if(commands[1].equalsIgnoreCase("byname")){
                    playlistName = commands[2];

                    if(commands.length == 4){
                        songId = Integer.parseInt(commands[3]);

                        return add.run(playlistName, songId, songs, playlists);
                    }
                    else if(commands.length > 4){
                        for(int i = 3; i < commands.length; i++){
                            songIds.add(Integer.parseInt(commands[i]));
                        }

                        return add.run(playlistName, songIds, songs, playlists);
                    }
                    else{
                        return "Invalid number of arguments!";
                    }
                }
                else if(commands[1].equalsIgnoreCase("byid")){
                    try {
                        playlistId = Integer.parseInt(commands[2]);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid playlist ID: " + commands[2]);
                        return "";
                    }
                    if(commands.length == 4){
                        songId = Integer.parseInt(commands[3]);

                        return add.run(playlistId, songId, songs, playlists);
                    }
                    else if(commands.length > 4){
                        for(int i = 3; i < commands.length; i++){
                            songIds.add(Integer.parseInt(commands[i]));
                        }

                        return add.run(playlistId, songIds, songs, playlists);
                    }
                    else{
                        return "Invalid number of arguments!";
                    }
                }
            }
        }

        return "Unknown command";
    }
}
