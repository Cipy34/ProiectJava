package Java_Project.Pagination;

import Java_Project.Audit.Audit;
import Java_Project.Song.Playlist;
import Java_Project.User.User;

import java.util.List;
import java.util.Scanner;

public class ListAudit {

    /**
     * realizeaza paginarea pentru lista de audit
     * @param audits lista de audit pentru fiecare user
     * @param nr numarul de afisari pe pagina
     */

    public void run(List<String> audits, int nr){
        int pages;
        if(audits.size() % nr == 0){
            pages = audits.size() / nr;
        }
        else{
            pages = audits.size() / nr + 1;
        }
        System.out.println("Page " + 1 + " of " + pages + "(" + nr + " items per page)");
        int nrPage = 2;
        Scanner scanner = new Scanner(System.in);
        String choice;
        for(int i = 1; i <= audits.size(); i++){
            String audit = audits.get(i-1);
            System.out.println(i + ". " + audit);
            if(i % nr == 0 && nrPage <= pages){
                System.out.println("To return the next page run the query as follows: \nlist audits " + nrPage);
                System.out.println("To return to the menu run any word!");
                choice = scanner.nextLine();
                if(!choice.equals("list audits " + nrPage)){
                    return;
                }
                System.out.println("Page " + nrPage + " of " + pages + "(" + nr + " items per page)");
                nrPage++;
            }
        }
    }
}
