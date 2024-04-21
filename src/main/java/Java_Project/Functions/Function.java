package Java_Project.Functions;

import Java_Project.User.Role;

public final class Function {
    private final String command;
    private final int size;
    private final Role role;

    public Function(String command, int size, Role role) {
        this.command = command;
        this.size = size;
        this.role = role;
    }

    public String getCommand(){
        return command;
    }

    public int getSize(){
        return size;
    }

    public Role getRole(){
        return role;
    }
}


