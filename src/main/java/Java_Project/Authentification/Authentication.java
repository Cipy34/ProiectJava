package Java_Project.Authentification;

import Java_Project.User.User;

import java.util.Map;
import java.util.Scanner;

public abstract class Authentication {
    protected final Map<String, String> users;
    protected final User currentuser;

    public Authentication(Map<String, String> users, User currentuser) {
        this.users = users;
        this.currentuser = currentuser;
    }

    abstract void run();
}
