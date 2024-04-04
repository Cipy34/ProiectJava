package Java_Project.SongCommands;

import Java_Project.Song.Song;

import java.util.*;

public final class SongById {
    public Song songById(int id, List<Song> songs){
        Song currentsong = null;

        for(Song song : songs){
            if(song.getId() == id)
                currentsong = song;
        }

        if(currentsong == null){
            System.out.println("Song with identifier " + id + " does not exist.");
            return null;
        }
        return currentsong;
    }

    public List<Song> songById(List<Integer> ids, List<Song> songs){
        Set<Integer> set = new HashSet<>();
        List<Song> currentsongs = new ArrayList<>();

        for(int id : ids){
            if(!set.add(id)){
                System.out.println("You can not add the same song to a playlist");
                return null;
            }
            else{
                Song song = songById(id, songs);
                if(song == null){
                    return null;
                }
                else{
                    currentsongs.add(song);
                }
            }
        }

        return currentsongs;
    }
}
