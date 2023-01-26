package Clients;

public class Client {
    String name;
    String lastName;
    String userName;
    String password;

    public String getUserName() {
        return userName;
    }

    Client(String name, String lastName, String userName, String password) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }
}
