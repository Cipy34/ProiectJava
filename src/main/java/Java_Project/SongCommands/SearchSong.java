package Java_Project.SongCommands;

import Java_Project.Pagination.ListSongs;
import Java_Project.Song.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class SearchSong {
    private final List<Song> songs;

    public SearchSong(List<Song> songs) {
        this.songs = songs;
    }

    /**
     * selecteaza toate melodiile al caror autor incep cu criteriul specific
     * @param criteria criteriul de selectare
     */

    public void runAuthor(String criteria){
        List<String> result = new ArrayList<>();
        for(Song song : songs){
            if(song.getAuthorName().startsWith(criteria)){
                result.add(song.getSongName() + " - " + song.getAuthorName() + " (" + song.getYear() + ")  [ID: " + song.getId() + "]");
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the number of songs per page: ");
        String nrPage = scanner.next();
        int intNrPage;
        try{
            intNrPage = Integer.parseInt(nrPage);
        }
        catch (NumberFormatException e){
            System.err.println("Error parsing integer at index " + nrPage + ": " + e.getMessage());
            return;
        }

        ListSongs ls = new ListSongs();
        ls.run(result, intNrPage);
    }

    /**
     * Selecteaza toate melodiile al caror nume incepe cu criteriul specific
     * @param criteria criteriul de selectare
     */

    public void run(String criteria){
        List<String> result = new ArrayList<>();
        for(Song song : songs){
            if(song.getSongName().startsWith(criteria)){
                result.add(song.getSongName() + " - " + song.getAuthorName() + " (" + song.getYear() + ")  [ID: " + song.getId() + "]");
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the number of songs per page: ");
        String nrPage = scanner.next();
        int intNrPage;
        try{
            intNrPage = Integer.parseInt(nrPage);
        }
        catch (NumberFormatException e){
            System.err.println("Error parsing integer at index " + nrPage + ": " + e.getMessage());
            return;
        }

        ListSongs ls = new ListSongs();
        ls.run(result, intNrPage);
    }

    /**
     * Selecteaza toate melodiile aparute in anul respectiv
     * @param criteria anul lansarii
     */

    public void run(int criteria){
        List<String> result = new ArrayList<>();
        for(Song song : songs){
            if(song.getYear() == criteria){
                result.add(song.getSongName() + " - " + song.getAuthorName() + " (" + song.getYear() + ")  [ID: " + song.getId() + "]");
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the number of songs per page: ");
        String nrPage = scanner.next();
        int intNrPage;
        try{
            intNrPage = Integer.parseInt(nrPage);
        }
        catch (NumberFormatException e){
            System.err.println("Error parsing integer at index " + nrPage + ": " + e.getMessage());
            return;
        }

        ListSongs ls = new ListSongs();
        ls.run(result, intNrPage);
    }

    /**
     * selecteaza melodia care are ca id criteriul specific
     * @param criteria id ul melodiei
     */

    public void runId(int criteria){
        List<String> result = new ArrayList<>();
        for(Song song : songs){
            if(song.getId() == criteria){
                result.add(song.getSongName() + " - " + song.getAuthorName() + " (" + song.getYear() + ")  [ID: " + song.getId() + "]");
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the number of songs per page: ");
        String nrPage = scanner.next();
        int intNrPage;
        try{
            intNrPage = Integer.parseInt(nrPage);
        }
        catch (NumberFormatException e){
            System.err.println("Error parsing integer at index " + nrPage + ": " + e.getMessage());
            return;
        }

        ListSongs ls = new ListSongs();
        ls.run(result, intNrPage);
    }
}
