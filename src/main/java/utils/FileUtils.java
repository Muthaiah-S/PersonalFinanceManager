package utils;

import model.User;

import java.io.*;
import java.util.Optional;

public class FileUtils {

    public static boolean saveUser(User user, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getBalance());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Optional<User> loadUser(String username, String password, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(username) && data[1].equals(password)) {
                    User user = new User(username, password);
                    user.addBalance(Double.parseDouble(data[2]));
                    return Optional.of(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
