package Java_Project.Functions;

import java.util.ArrayList;
import java.util.List;

import static Java_Project.User.Role.*;

public final class AddFunction {
    public List<Function> setFunction(){
        List<Function> list = new ArrayList<>();
        list.add(new Function("login", 3, Anonymous));
        list.add(new Function("logout", 1, AdminAuth));
        list.add(new Function("register", 3, Anonymous));
        list.add(new Function("promote", 2, Administrator));
        list.add(new Function("create song", 4, Administrator));
        list.add(new Function("create playlist", 2, AdminAuth));
        list.add(new Function("add byname", -3, AdminAuth));
        list.add(new Function("add", -4, AdminAuth));
        list.add(new Function("list", 2, AdminAuth));
        list.add(new Function("export playlist", 2, AdminAuth));
        list.add(new Function("export", 3, AdminAuth));
        list.add(new Function("search author", 2, AdminAuth));
        list.add(new Function("search name", 2, AdminAuth));
        list.add(new Function("search", 3, AdminAuth));
        list.add(new Function("audit", 2, Administrator));

        return list;
    }
}
