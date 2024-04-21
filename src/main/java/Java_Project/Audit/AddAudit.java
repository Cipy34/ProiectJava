package Java_Project.Audit;

import Java_Project.User.User;

import java.util.List;

public final class AddAudit {
    public void run(String msg, List<Audit> audits, User currentuser){
        for(Audit audit : audits){
            if(audit.getCurrentUser().getUsername().equals(currentuser.getUsername())){
                audit.addCommand(msg);
            }
        }
    }
}
