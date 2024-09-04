package service;

import model.Transaction;

import java.util.List;

public class ReportService {

    public void generateReport(List<Transaction> transactions) {
        System.out.println("----- Transaction Report -----");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDescription() + " - " + transaction.getAmount() + " - " + transaction.getCategory());
        }
        System.out.println("--------------------------------");
    }
}
