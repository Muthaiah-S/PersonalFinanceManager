package main;

import service.UserService;
import model.User;

import java.util.Optional;
import java.util.Scanner;

public class Authentication {

    private UserService userService = new UserService();

    public Optional<User> loginOrRegister() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Choose an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (choice == 1) {
            return login(scanner);
        } else if (choice == 2) {
            return register(scanner);
        } else {
            System.out.println("Invalid choice!");
            return Optional.empty();
        }
    }

    private Optional<User> login(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        return userService.loginUser(username, password);
    }

    private Optional<User> register(Scanner scanner) {
        System.out.print("New Username: ");
        String username = scanner.nextLine();
        System.out.print("New Password: ");
        String password = scanner.nextLine();

        if (userService.registerUser(username, password)) {
            System.out.println("Registration successful!");
            return userService.loginUser(username, password);
        } else {
            System.out.println("Registration failed!");
            return Optional.empty();
        }
    }
}
