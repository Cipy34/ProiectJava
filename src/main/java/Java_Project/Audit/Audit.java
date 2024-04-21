package Java_Project.Audit;

import Java_Project.User.User;

public class Audit {
    private final User currentUser;
    private String commands;

    public Audit(User currentUser) {
        this.currentUser = currentUser;
        commands = "";
    }

    public void addCommand(String command){
        if(!commands.isEmpty()){
            commands = commands.substring(0, commands.length()-1) + ", ";
        }else{
            commands += "{";
        }

        commands += command;
        commands += "}";
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public String getCommands(){
        return commands;
    }
}
