package org.example.DailyQuotes;

import org.example.DailyQuotes.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User newUser);
}
