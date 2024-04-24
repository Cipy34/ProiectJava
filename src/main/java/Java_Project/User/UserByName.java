package Java_Project.User;

import java.util.List;

public class UserByName {

    /**
     * Returneaza un obiect al clasei User in functie de nume
     * @param userName criteriul dat pentru selectie
     * @param users lista de useri
     * @return
     */

    public User ubn(String userName, List<User> users){
        for(User user : users){
            if(user.getUsername().equals(userName)){
                return user;
            }
        }
        return null;
    }
}
