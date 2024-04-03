package Java_Project.User;

public class User {
    private String username;
    private String password;
    private Role role;
    private final int id;
    private static int nextid = 0;

    public User(){
        this.username = "";
        this.password = "";
        this.role = Role.Anonymous;
        this.id = nextid++;
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.id = nextid++;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword(){
        return password;
    }

    public String getUsername(){
        return username;
    }
    public int getId(){
        return id;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }
}