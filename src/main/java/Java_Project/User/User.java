package Java_Project.User;

public final class User {
    private final String username;
    private final String password;
    private Role role;

    public User(){
        this.username = "";
        this.password = "";
        this.role = Role.Anonymous;
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
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

    public void setRole(Role role){
        this.role = role;
    }
}