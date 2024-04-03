package Java_Project.Authentification;

import Java_Project.User.Role;
import Java_Project.User.User;

import java.util.List;

public final class Logout extends Authentication{
    public Logout(List<User> users, User currentuser) {
        super(users, currentuser);
    }

    @Override
    public String run() {
        currentuser.setRole(Role.Anonymous);
        currentuser.setPassword("");
        currentuser.setUsername("");

        return "Successfully logged out.";
    }
}
