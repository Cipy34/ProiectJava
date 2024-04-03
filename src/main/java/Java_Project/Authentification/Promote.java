package Java_Project.Authentification;

import Java_Project.User.Role;
import Java_Project.User.User;

import java.util.List;

public final class Promote extends Authentication{
    private final String username;
    public Promote(List<User> users, User currentuser, String username) {
        super(users, currentuser);
        this.username = username;
    }

    @Override
    public String run() {
        for(User user : users){
            if(user.getUsername().equals(username)){
                user.setRole(Role.Administrator);
                return username + " is now an administrator!";
            }
        }

        return "Specified user does not exist!";
    }
}
