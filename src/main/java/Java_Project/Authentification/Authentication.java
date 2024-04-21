package Java_Project.Authentification;

import Java_Project.User.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public abstract class Authentication {
    protected final List<User> users;
    protected final User currentuser;


    public Authentication(List<User> users, User currentuser) {
        this.users = users;
        this.currentuser = currentuser;
    }

    public abstract String run() throws SQLException, IOException;
}
