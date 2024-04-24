package Java_Project.SongCommands;

import Java_Project.DataBaseCommands.DbCommand;
import Java_Project.Song.Song;

import java.sql.SQLException;
import java.util.List;

public final class CreateSong extends SongCommands{
    public CreateSong(List<Song> songs, Song currentsong) {
        super(songs, currentsong);
    }

    /**
     * creeaza o melodie noua si verifica daca aceasta exista
     * @return
     * @throws SQLException
     */

    @Override
    public String run() throws SQLException {
        for(Song song : songs){
            if(song.getSongName().equals(currentsong.getSongName()) &&
                    song.getAuthorName().equals(currentsong.getAuthorName()))
                return "This song is already part of the library!";
        }

        songs.add(currentsong);
        DbCommand dbc = new DbCommand();
        dbc.insertSong(currentsong);
        return "Added " + currentsong.getSongName() + " by " + currentsong.getAuthorName() + " to the library.";
    }
}
