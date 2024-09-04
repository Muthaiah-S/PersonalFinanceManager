package model;

public class User {
    private String username;
    private String password;
    private double balance;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void subtractBalance(double amount) {
        this.balance -= amount;
    }
}
