package com.topia.epdms.model;
import org.springframework.data.annotation.Id;

public class Users {

    @Id
    private int id;
    private String username;
    private String password;

    /*public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }*/

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
