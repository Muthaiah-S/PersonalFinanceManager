package main;

import model.Category;
import model.User;
import service.FinanceService;
import service.ReportService;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Authentication authentication = new Authentication();
        Optional<User> optionalUser = authentication.loginOrRegister();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            FinanceService financeService = new FinanceService(user);
            ReportService reportService = new ReportService();
            Scanner scanner = new Scanner(System.in);

            boolean running = true;
            while (running) {
                System.out.println("1. Add Income");
                System.out.println("2. Add Expense");
                System.out.println("3. View Balance");
                System.out.println("4. Generate Report");
                System.out.println("5. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Description: ");
                        String incomeDesc = scanner.nextLine();
                        System.out.print("Amount: ");
                        double incomeAmount = scanner.nextDouble();
                        financeService.addIncome(incomeDesc, incomeAmount);
                        break;
                    case 2:
                        System.out.print("Description: ");
                        String expenseDesc = scanner.nextLine();
                        System.out.print("Amount: ");
                        double expenseAmount = scanner.nextDouble();
                        System.out.print("Category (1- Income, 2- Rent, 3- Groceries, 4- Entertainment, 5- Other): ");
                        int cat = scanner.nextInt();
                        Category category = Category.values()[cat - 1];
                        financeService.addExpense(expenseDesc, expenseAmount, category);
                        break;
                    case 3:
                        System.out.println("Current Balance: " + financeService.getBalance());
                        break;
                    case 4:
                        reportService.generateReport(financeService.getTransactions());
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } else {
            System.out.println("Authentication failed!");
        }
    }
}
