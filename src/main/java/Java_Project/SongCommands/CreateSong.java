package Java_Project.SongCommands;

import Java_Project.Song.Song;
import Java_Project.User.User;

import java.util.List;

public final class CreateSong extends SongCommands{
    public CreateSong(List<Song> songs, Song currentsong, User currentuser) {
        super(songs, currentsong, currentuser);
    }

    @Override
    public String run() {
        for(Song song : songs){
            if(song.getSongName().equals(currentsong.getSongName()) &&
                    song.getAuthorName().equals(currentsong.getAuthorName()))
                return "This song is already part of the library!";
        }

        songs.add(currentsong);
        return "Added " + currentsong.getSongName() + " by " + currentsong.getAuthorName() + " to the library.";
    }
}
