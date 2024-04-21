package Java_Project.Pagination;

import Java_Project.Song.Playlist;

import java.util.List;
import java.util.Scanner;

public class ListPlaylist{
    public void run(List<Playlist> playlists, int nr) {
        int pages;
        if(playlists.size() % nr == 0){
            pages = playlists.size() / nr;
        }
        else{
            pages = playlists.size() / nr + 1;
        }
        System.out.println("Page " + 1 + " of " + pages + "(" + nr + " items per page)");
        int nrPage = 2;
        Scanner scanner = new Scanner(System.in);
        String choice;
        for(int i = 1; i <= playlists.size(); i++){
            Playlist playlist = playlists.get(i-1);
            System.out.println(i + ". " + playlist.getPlaylistName() + " [ID: " + playlist.getId() + "];");
            if(i % nr == 0){
                System.out.println("To return the next page run the query as follows: \nlist playlists " + nrPage);
                System.out.println("To return to the menu run any word!");
                choice = scanner.nextLine();
                if(!choice.equals("list playlists " + nrPage)){
                    return;
                }
                System.out.println("Page " + nrPage + " of " + pages + "(" + nr + " items per page)");
                nrPage++;
            }
        }
    }
}
