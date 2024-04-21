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

    public void run(String playlistName) throws IOException {
        String fileName = "export_" + currentUser.getUsername() + "_" + playlistName + "_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".json";
        for(Playlist playlist : playlists){
            if(playlist.getPlaylistName().equals(playlistName)){
                JSON json = new JSON();
                json.write(fileName, playlist);
            }
        }
    }
}
