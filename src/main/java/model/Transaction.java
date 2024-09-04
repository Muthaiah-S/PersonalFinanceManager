package model;

public class Transaction {
    private String description;
    private double amount;
    private Category category;

    public Transaction(String description, double amount, Category category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }
}
