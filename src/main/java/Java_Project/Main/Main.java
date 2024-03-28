package Java_Project.Main;

import Java_Project.Authentification.Authentication;
import Java_Project.Authentification.Command;
import Java_Project.User.Role;
import Java_Project.User.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> users = new HashMap<>();
        users.put("Cipy", "123");
        users.put("Cipy34", "123");

        User currentuser = new User();

        Authentication au = new Command(users, currentuser);
        ((Command) au).run();

        System.out.println(currentuser.getUsername());
        ((Command) au).run();

    }
}
