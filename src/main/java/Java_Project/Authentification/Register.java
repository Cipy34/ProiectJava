package Java_Project.Authentification;

import Java_Project.Exceptions.LoginException;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.util.Map;

public class Register extends Authentication{
    private final String password;
    private final String username;
    public Register(Map<String, String> users, User currentuser, String username, String password) {
        super(users, currentuser);
        this.password = password;
        this.username = username;
    }

    @Override
    void run() {
        if(!users.containsKey(username)){
            currentuser.setUsername(username);
            currentuser.setPassword(password);
            currentuser.setRole(Role.Authentificated);

            users.put(username, password);
        }
        else{
            throw new LoginException("register error");
        }
    }
}
