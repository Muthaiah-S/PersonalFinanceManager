package service;

import model.User;
import utils.FileUtils;

import java.util.Optional;

public class UserService {
    private static final String DATA_FILE = "src/main/resources/users_data.txt";

    public boolean registerUser(String username, String password) {
        User user = new User(username, password);
        return FileUtils.saveUser(user, DATA_FILE);
    }

    public Optional<User> loginUser(String username, String password) {
        return FileUtils.loadUser(username, password, DATA_FILE);
    }
}
