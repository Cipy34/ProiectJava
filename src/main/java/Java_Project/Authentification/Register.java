package Java_Project.Authentification;

import Java_Project.DataBaseCommands.DbCommand;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.sql.SQLException;
import java.util.List;

public final class Register extends Authentication{
    private final String password;
    private final String username;
    public Register(List<User> users, User currentuser, String username, String password) {
        super(users, currentuser);
        this.password = password;
        this.username = username;
    }

    /**
     * realizeaza inregistrarea unui user si il logheaza automat
     * @return
     * @throws SQLException
     */

    @Override
    public String run() throws SQLException {
        for(User user : users){
            if(user.getUsername().equals(username)) {
                return "User with given username already exists! Please try again!";
            }
        }
        User aux = new User(username, password, Role.Authentificated);
        if(users.size() == 0)
            aux.setRole(Role.Administrator);

        currentuser.setRole(aux.getRole());
        currentuser.setUsername(username);
        currentuser.setPassword(password);

        users.add(aux);
        DbCommand dbc = new DbCommand();
        dbc.insertUser(aux);
        Login log = new Login(users, currentuser, username, password);
        log.run();
        return "Registered account with user name " + username + ". ";
    }
}
