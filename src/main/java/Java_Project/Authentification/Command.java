package Java_Project.Authentification;

import Java_Project.User.User;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Command extends Authentication{
    public Command(List<User> users, User currentuser) {
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
                Scanner scanner = new Scanner(System.in);
                String command;

                command = scanner.next();
                if(command.equals("logout")){
                    Logout l = new Logout(users, currentuser);
                    l.run();
                }
                break;
            }

            case Administrator -> {
                Scanner scanner = new Scanner(System.in);
                String command;
                String username;

                command = scanner.next();
                if(command.equals("logout")){
                    Logout l = new Logout(users, currentuser);
                    l.run();
                }

                if(command.equals("promote")){
                    username = scanner.next();
                    Promote p = new Promote(users, currentuser, username);
                    p.run();
                }
                break;
            }
        }
    }
}
