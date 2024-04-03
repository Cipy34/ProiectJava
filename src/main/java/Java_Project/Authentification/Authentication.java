package Java_Project.Authentification;

import Java_Project.User.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class Authentication {
    protected final List<User> users;
    protected User currentuser;


    public Authentication(List<User> users, User currentuser) {
        this.users = users;
        this.currentuser = currentuser;
    }

    public abstract String run() throws SQLException;
}
