package Java_Project.Authentification;

import Java_Project.User.Role;
import Java_Project.User.User;

import java.util.List;
import java.util.Map;

public class Promote extends Authentication{
    private final String username;
    public Promote(List<User> users, User currentuser, String username) {
        super(users, currentuser);
        this.username = username;
    }

    @Override
    void run() {
        for(User user : users){
            if(user.getUsername().equals(username)){
                user.setRole(Role.Administrator);
            }
        }
    }
}
