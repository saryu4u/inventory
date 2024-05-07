package db_objs;

import java.math.BigDecimal;

public class User {

    private final int id;
    private final String username, password, name, email, address, status;

    public User(int id, String username, String password, String name, String email, String address, String status) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.email = email;
        this.password = password;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

}
