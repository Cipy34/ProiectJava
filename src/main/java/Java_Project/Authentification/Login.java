package Java_Project.Authentification;

import Java_Project.Exceptions.LoginException;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.util.List;
import java.util.Map;

public final class Login extends Authentication {
    private final String username;
    private final String password;
    public Login(List<User> users, User currentuser, String username, String password) {
        super(users, currentuser);
        this.username = username;
        this.password = password;
    }

    @Override
    public String run() {
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                currentuser.setRole(user.getRole());
                currentuser.setUsername(username);
                currentuser.setPassword(password);

                return "You are now authenticated as " + username + ".";
            }
        }

        return "Username or password is invalid. Please try again!";
    }
}
