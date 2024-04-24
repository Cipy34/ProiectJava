package Java_Project.Audit;

import Java_Project.User.User;

import java.util.List;

public final class AddAudit {

    /**
     * stocheaza comanda folosita de user intr-o lista de string-uri
     * @param msg comanda scrisa de user
     * @param audits lista de audit(pentru fiecare user)
     * @param currentuser user-ul curent
     */

    public void run(String msg, List<Audit> audits, User currentuser){
        for(Audit audit : audits){
            if(audit.getCurrentUser().getUsername().equals(currentuser.getUsername())){
                audit.addCommand(msg);
            }
        }
    }
}
