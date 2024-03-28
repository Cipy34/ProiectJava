package Java_Project.Authentification;

import Java_Project.Exceptions.LoginException;
import Java_Project.User.User;

import java.util.List;
import java.util.Scanner;

public class Command extends Authentication{
    public Command(List<User> users, User currentuser) {
        super(users, currentuser);
    }

    @Override
    public String run() {
        switch (currentuser.getRole()){
            case Anonymous -> {
                Scanner scanner = new Scanner(System.in);
                String command, username, password;
                String sentence = scanner.nextLine();

                String[] commands = sentence.split("\\s+");
                if(commands[0].equals("promote")){
                    throw new LoginException("You do not have the permission to use this!");
                }

                command = commands[0];

                if(command.equals("login")){
                    if(commands.length != 3)
                        return "Invalid number of arguments!";

                    username = commands[1];
                    password = commands[2];
                    Login l = new Login(users, currentuser, username, password);
                    System.out.println(l.run());
                    return null;
                }

                if(command.equals("register")){
                    if(commands.length != 3)
                        return "Invalid number of arguments!";

                    username = commands[1];
                    password = commands[2];
                    Register r = new Register(users, currentuser, username, password);
                    System.out.println(r.run());
                    return null;
                }
            }

            case Authentificated -> {
                Scanner scanner = new Scanner(System.in);
                String command;
                String sentence = scanner.nextLine();

                String[] commands = sentence.split("\\s+");
                if(commands[0].equals("promote")){
                    throw new LoginException("You do not have the permission to use this!");
                }

                command = commands[0];
                if(command.equals("logout")){
                    if(commands.length != 1)
                        return "Invalid number of arguments!";

                    Logout l = new Logout(users, currentuser);
                    System.out.println(l.run());
                    return null;
                }
            }

            case Administrator -> {
                Scanner scanner = new Scanner(System.in);
                String command;
                String username;
                String sentence = scanner.nextLine();

                String[] commands = sentence.split("\\s+");

                command = commands[0];

                if(command.equals("logout")){
                    if(commands.length != 1)
                        return "Invalid number of arguments!";

                    Logout l = new Logout(users, currentuser);
                    System.out.println(l.run());
                    return null;
                }

                if(command.equals("promote")){
                    if(commands.length != 2)
                        return "Invalid number of arguments!";

                    username = commands[1];
                    Promote p = new Promote(users, currentuser, username);
                    System.out.println(p.run());
                    return null;
                }
            }
        }
        return "Unknown command";
    }
}
