package Java_Project.Authentification;

import Java_Project.Exceptions.LoginException;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.util.List;
import java.util.Map;

public class Register extends Authentication{
    private final String password;
    private final String username;
    public Register(List<User> users, User currentuser, String username, String password) {
        super(users, currentuser);
        this.password = password;
        this.username = username;
    }

    @Override
    void run() {
        for(User user : users){
            if(!user.getUsername().equals(username)) {
                currentuser.setUsername(username);
                currentuser.setPassword(password);
                currentuser.setRole(Role.Authentificated);

                users.add(new User(username, password, Role.Authentificated));
            }
        }
    }
}
