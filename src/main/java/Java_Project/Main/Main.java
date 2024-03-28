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

        Authentication au = new Command(users, currentuser);
        System.out.println(((Command) au).run());
        System.out.println(((Command) au).run());
    }
}
