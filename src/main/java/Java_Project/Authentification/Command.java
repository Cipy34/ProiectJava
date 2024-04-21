package Java_Project.Authentification;

import Java_Project.BackupDataBase.Backup;
import Java_Project.DataBaseCommands.DbCommand;
import Java_Project.Formats.SongsCSV;
import Java_Project.Functions.AddFunction;
import Java_Project.Functions.Function;
import Java_Project.Pagination.ListPlaylist;
import Java_Project.PlaylistCommands.Add;
import Java_Project.PlaylistCommands.CreatePlaylist;
import Java_Project.PlaylistCommands.ExportPlaylist;
import Java_Project.Song.Playlist;
import Java_Project.Song.Song;
import Java_Project.SongCommands.CreateSong;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public final class Command extends Authentication{
    private final List<Song> songs;
    private final List<Playlist> playlists;
    public Command(List<User> users, User currentuser, List<Song> songs, List<Playlist> playlists) {
        super(users, currentuser);
        this.songs = songs;
        this.playlists = playlists;
    }

    private List<String> comm(){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] commands = line.split("\\s+");
        List<String> list = new ArrayList<>();
        int prefix2 = 0;
        for(int i = 0; i < commands.length; i++){
            if(commands[i].charAt(0) == '"'){
                StringBuilder aux = new StringBuilder();
                if(commands[i].charAt(commands[i].length() - 1) == '"'){
                    aux.append(commands[i].substring(1, commands[i].length() - 1));
                    prefix2 = 1;
                    list.add(String.valueOf(aux));
                    continue;
                }
                aux.append(commands[i].substring(1));
                i++;
                while(commands[i].charAt(commands[i].length() - 1) != '"'){
                    aux.append(' ');
                    aux.append(commands[i]);
                    i++;
                    if(i == commands.length){
                        System.out.println("Expected \" at final");
                        return null;
                    }
                }
                aux.append(' ');
                aux.append(commands[i].substring(0, commands[i].length() - 1));
                list.add(String.valueOf(aux));
                prefix2 = 1;
            }
            else{
                list.add(commands[i]);
            }
        }
        if(prefix2 == 1){
            list.set(0, list.get(0) + ' ' + list.get(1));
            for(int i = 2; i < list.size(); i++){
                list.set(i - 1, list.get(i));
            }
            list.remove(list.size()-1);
        }
        return list;
    }

    @Override
    public String run() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> l = comm();
        if(l.get(0).equalsIgnoreCase("quit")){
            return "quit";
        }

        List<Function> functions;
        AddFunction af = new AddFunction();
        functions = af.setFunction();

        List<String> pre = new ArrayList<>();

        for(Function function : functions){
            pre.add(function.getCommand());
            if(l.get(0).equalsIgnoreCase(function.getCommand())){
                if(function.getRole() == Role.AdminAuth){
                    if(currentuser.getRole() != Role.Administrator
                        && currentuser.getRole() != Role.Authentificated)
                            return "You do not have the permission to use this!";
                }
                else{
                    if(currentuser.getRole() != function.getRole())
                        return "You do not have the permission to use this!";
                }

                if(function.getSize() < 0 && l.size() >= function.getSize()*(-1)
                        || function.getSize() > 0 && l.size() == function.getSize()){

                }
                else{
                    return "Invalid number of arguments!";
                }
            }
        }

        switch (l.get(0).toLowerCase()){
            case "login" -> {
                Login log = new Login(users, currentuser, l.get(1), l.get(2));
                System.out.println(log.run());
                return "";
            }

            case "register" -> {
                Register r = new Register(users, currentuser, l.get(1), l.get(2));
                return r.run();
            }

            case "promote" -> {
                Promote p = new Promote(users, currentuser, l.get(1));
                return p.run();
            }

            case "logout" -> {
                Logout log = new Logout(users, currentuser);
                return log.run();
            }

            case "create song" -> {
                try{
                    Integer.parseInt(l.get(3));
                }
                catch (NumberFormatException e){
                    System.err.println("Error parsing integer at index " + l.get(3) + ": " + e.getMessage());
                    return "";
                }
                Song song = new Song(l.get(1), l.get(2), Integer.parseInt(l.get(3)));
                CreateSong cs = new CreateSong(songs, song);
                return cs.run();
            }

            case "create playlist" -> {
                for(User user : users){
                    if(Objects.equals(user.getUsername(), currentuser.getUsername())){
                        Playlist playlist = new Playlist(l.get(1), user);
                        CreatePlaylist cp = new CreatePlaylist();
                        return cp.run(playlist, user, playlists);
                    }
                }

            }

            case "add byname" -> {
                List<Integer> ids = new ArrayList<>();
                for(int i = 2; i < l.size(); i++) {
                    try{
                        ids.add(Integer.parseInt(l.get(i)));
                    }
                    catch (NumberFormatException e){
                        System.err.println("Error parsing integer at index " + i + ": " + e.getMessage());
                        return "";
                    }
                }

                Add add = new Add();
                return add.run(l.get(1), ids, songs, playlists);
            }

            case "add" -> {
                if(!l.get(1).equalsIgnoreCase("byid"))
                    return "Wrong command";
                List<Integer> ids = new ArrayList<>();
                for(int i = 3; i < l.size(); i++) {
                    try{
                        ids.add(Integer.parseInt(l.get(i)));
                        Integer.parseInt(l.get(2));
                    }
                    catch (NumberFormatException e){
                        System.err.println("Error parsing integer: " + e.getMessage());
                        return "";
                    }

                }

                Add add = new Add();
                return add.run(Integer.parseInt(l.get(2)), ids, songs, playlists);
            }

            case "list" -> {
                if(!l.get(1).equals("playlists"))
                    return "Wrong command";
                System.out.println("Select the number of playlists per page: ");
                String nrPage = scanner.next();
                int intNrPage;
                try{
                    intNrPage = Integer.parseInt(nrPage);
                }
                catch (NumberFormatException e){
                    System.err.println("Error parsing integer at index " + nrPage + ": " + e.getMessage());
                    return "";
                }

                ListPlaylist lp = new ListPlaylist();
                lp.run(playlists, intNrPage);
                return "";
            }

            case "help" -> {
                if(currentuser.getRole() == Role.Anonymous)
                    return "login <username> <password>\nregister <username> <password>";
                if(currentuser.getRole() == Role.Administrator)
                    return "logout\naudit <username>\npromote <username>\ncreate song <songname> <authorname> <year>\nsearch <searchcriteria> <searchterm>\ncreate playlist <playlistname>\nadd byname <playlistname> <songid>\nadd byname <playlistname> <songid1> <songid2>...\nadd byid <playlistid> <songid>\nadd byid <playlistid> <songid1> <songid2>...\nexport playlist <playlistname> <format>\nlist playlist";
                if(currentuser.getRole() == Role.Authentificated)
                    return "logout\nsearch <searchcriteria> <searchterm>\ncreate playlist <playlistname>\nadd byname <playlistname> <songid>\nadd byname <playlistname> <songid1> <songid2>...\nadd byid <playlistid> <songid>\nadd byid <playlistid> <songid1> <songid2>...\nexport playlist <playlistname> <format>\nlist playlist";
            }

            case "reset" -> {
                DbCommand dbc = new DbCommand();
                dbc.resetDataBase();
                return "";
            }

            case "read" -> {
                SongsCSV scsv = new SongsCSV();
                scsv.readSongs(songs);
                return "";
            }

            case "export playlist" -> {
                ExportPlaylist ep = new ExportPlaylist(currentuser, playlists);
                ep.run(l.get(1));
            }
        }

        return "Unknown Command";
    }
}

