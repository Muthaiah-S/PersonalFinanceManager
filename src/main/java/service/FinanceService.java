package service;

import model.Transaction;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class FinanceService {
    private User user;
    private List<Transaction> transactions;

    public FinanceService(User user) {
        this.user = user;
        this.transactions = new ArrayList<>();
    }

    public void addIncome(String description, double amount) {
        Transaction income = new Transaction(description, amount, model.Category.INCOME);
        transactions.add(income);
        user.addBalance(amount);
    }

    public void addExpense(String description, double amount, model.Category category) {
        Transaction expense = new Transaction(description, amount, category);
        transactions.add(expense);
        user.subtractBalance(amount);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return user.getBalance();
    }
}
