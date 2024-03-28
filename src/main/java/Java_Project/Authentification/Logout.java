package Java_Project.Authentification;

import Java_Project.User.Role;
import Java_Project.User.User;

import java.util.List;
import java.util.Map;

public class Logout extends Authentication{
    public Logout(List<User> users, User currentuser) {
        super(users, currentuser);
    }

    @Override
    void run() {
        currentuser.setRole(Role.Anonymous);
        currentuser.setPassword("");
        currentuser.setUsername("");
    }
}
