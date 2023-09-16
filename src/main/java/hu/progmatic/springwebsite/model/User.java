package hu.progmatic.springwebsite.model;

public class User {
    String name;
    String address;

    Integer userID;

    public User(String name, String address, Integer userID) {
        this.name = name;
        this.address = address;
        this.userID = userID;
    }

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
