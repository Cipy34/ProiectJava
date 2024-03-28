package Java_Project.Authentification;

import Java_Project.Exceptions.LoginException;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.util.Map;

public final class Login extends Authentication {
    private final String username;
    private final String password;
    public Login(Map<String, String> users, User currentuser, String username, String password) {
        super(users, currentuser);
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        if(users.containsKey(username) &&
                users.get(username).equals(password)){
            currentuser.setRole(Role.Authentificated);
            currentuser.setPassword(password);
            currentuser.setUsername(username);
        }
        else {
            throw new LoginException("Username or Password Incorrect!");
        }
    }
}
