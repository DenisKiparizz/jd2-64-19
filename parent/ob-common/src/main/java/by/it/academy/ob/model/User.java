package by.it.academy.ob.model;

import java.util.Objects;

public class User {
    private String userName;
    private String password;
    private String role;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.role = "user";
    }
    public User(){
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUserName().equals(user.getUserName()) &&
                getPassword().equals(user.getPassword());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword());
    }
}
