package Java_Project.Pagination;

import Java_Project.Song.Playlist;

import java.util.List;
import java.util.Scanner;

public final class ListSongs {
    public void run(List<String> result, int nr){
        int pages;
        if(result.size() % nr == 0){
            pages = result.size() / nr;
        }
        else{
            pages = result.size() / nr + 1;
        }
        System.out.println("Page " + 1 + " of " + pages + "(" + nr + " items per page)");
        int nrPage = 2;
        Scanner scanner = new Scanner(System.in);
        String choice;
        for(int i = 1; i <= result.size(); i++){
            String song = result.get(i-1);
            System.out.println(song);
            if(i % nr == 0 && nrPage <= pages){
                System.out.println("To return the next page run the query as follows: \nlist songs " + nrPage);
                System.out.println("To return to the menu run any word!");
                choice = scanner.nextLine();
                if(!choice.equals("list songs " + nrPage)){
                    return;
                }
                System.out.println("Page " + nrPage + " of " + pages + "(" + nr + " items per page)");
                nrPage++;
            }
        }
    }
}
