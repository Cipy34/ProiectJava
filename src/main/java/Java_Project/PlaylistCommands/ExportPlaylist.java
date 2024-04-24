package Java_Project.PlaylistCommands;

import Java_Project.Formats.JSON;
import Java_Project.Song.Playlist;
import Java_Project.User.User;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public final class ExportPlaylist {
    private final User currentUser;
    private final List<Playlist> playlists;

    public ExportPlaylist(User currentUser, List<Playlist> playlists) {
        this.currentUser = currentUser;
        this.playlists = playlists;
    }

    /**
     * Exporteaza un playlist byName (afiseaza intr un fisier json)
     * @param playlistName numele playlist ului exportat
     * @throws IOException
     */


    public void run(String playlistName) throws IOException {
        String fileName = "export_" + currentUser.getUsername() + "_" + playlistName + "_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".json";
        for(Playlist playlist : playlists){
            if(playlist.getPlaylistName().equals(playlistName) && playlist.getCurrentuser().getUsername().equals(currentUser.getUsername())){
                JSON json = new JSON();
                json.write(fileName, playlist);
                break;
            }
            else{
                System.out.println("Playlist " + playlistName + " does not exist!");
            }
        }
    }

    /**
     * Exporteaza un playlist byId (afiseaza intr un fisier json)
     * @param playlistId id ul playlist ului care trebuie exportat
     * @throws IOException
     */

    public void run(int playlistId) throws IOException{
        for(Playlist playlist : playlists){
            if(playlist.getId() == playlistId && playlist.getCurrentuser().getUsername().equals(currentUser.getUsername())){
                JSON json = new JSON();
                String fileName = "export_" + currentUser.getUsername() + "_" + playlist.getPlaylistName() + "_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".json";
                json.write(fileName, playlist);
                break;
            }
            else{
                System.out.println("Playlist " + playlistId + " does not exist!");
            }
        }
    }
}
