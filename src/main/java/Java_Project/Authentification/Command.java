package Java_Project.Authentification;

import Java_Project.User.User;

import java.util.Map;
import java.util.Scanner;

public class Command extends Authentication{
    public Command(Map<String, String> users, User currentuser) {
        super(users, currentuser);
    }

    @Override
    public void run() {
        switch (currentuser.getRole()){
            case Anonymous -> {
                Scanner scanner = new Scanner(System.in);
                String command, username, password;

                command = scanner.next();
                username = scanner.next();
                password = scanner.next();

                if(command.equals("login")){
                    Login l = new Login(users, currentuser, username, password);
                    l.run();
                }

                if(command.equals("register")){
                    Register r = new Register(users, currentuser, username, password);
                    r.run();
                }

                break;
            }

            case Authentificated -> {
                
                break;
            }

            case Administrator -> {

                break;
            }
        }
    }
}
