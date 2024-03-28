package Java_Project.Main;

import Java_Project.Authentification.Authentication;
import Java_Project.Authentification.Command;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Cipy", "123", Role.Authentificated));
        users.add(new User("Cipy34", "123", Role.Authentificated));
        users.add(new User("Cipy345", "123", Role.Administrator));

        User currentuser = new User();

        Command au = new Command(users, currentuser);

//        if(au.run() != null)
//            System.out.println(au.run());

        String msg = au.run();
        if(msg != null)
            System.out.println(msg);
    }
}
