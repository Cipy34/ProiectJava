package Java_Project.Audit;

import Java_Project.User.User;

import java.util.ArrayList;
import java.util.List;

public class Audit {
    private final User currentUser;
    private List<String> commands;

    public Audit(User currentUser) {
        this.currentUser = currentUser;
        this.commands = new ArrayList<>();
    }

    /**
     * face adaugarea propriu zisa a comenzii in lista de string-uri a user-ului
     * @param command comanda scrisa de user
     */

    public void addCommand(String command){
        commands.add(command);
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public List<String> getCommands(){
        return commands;
    }
}
