package Java_Project.Authentification;

import Java_Project.Exceptions.LoginException;
import Java_Project.Pagination.Pagination;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public final class Command extends Authentication{
    public Command(List<User> users, User currentuser) {
        super(users, currentuser);
    }

    @Override
    public String run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] commands = line.split("\\s+");
        String command = commands[0].toLowerCase();
        String username, password;

        if(command.equals("quit"))
            return "quit";

        switch (command){
            case "login" -> {
                if(currentuser.getRole() != Role.Anonymous)
                    return "You do not have the permission to use this!";

                if(commands.length != 3)
                    return "Invalid number of arguments!";

                username = commands[1];
                password = commands[2];
                Login l = new Login(users, currentuser, username, password);
                System.out.println(l.run());
                return "";
            }

            case "register" -> {
                if(currentuser.getRole() != Role.Anonymous)
                    return "You do not have the permission to use this!";

                if(commands.length != 3)
                    return "Invalid number of arguments!";

                username = commands[1];
                password = commands[2];
                Register r = new Register(users, currentuser, username, password);
                System.out.println(r.run());
                Login l = new Login(users, currentuser, username, password);
                l.run();
                return "";
            }

            case "promote" -> {
                if(currentuser.getRole() != Role.Administrator)
                    return "You do not have the permission to use this!";

                if(commands.length != 2)
                    return "Invalid number of arguments!";

                username = commands[1];
                Promote p = new Promote(users, currentuser, username);
                System.out.println(p.run());
                return "";
            }

            case "logout" -> {
                if(currentuser.getRole() == Role.Anonymous)
                    return "You do not have the permission to use this!";

                if(commands.length != 1)
                    return "Invalid number of arguments!";

                Logout l = new Logout(users, currentuser);
                System.out.println(l.run());
                return "";
            }

            case "create" -> {
                if(currentuser.getRole() != Role.Administrator)
                    return "You do not have the permission to use this!";

                if(commands.length != 5)
                    return "Invalid number of arguments!";

                if(!commands[1].toLowerCase().equals("song"))
                    return "Did you meant 'song'? Try again!";

                
                return "";
            }
        }

        return "Unknown command";
    }
}
