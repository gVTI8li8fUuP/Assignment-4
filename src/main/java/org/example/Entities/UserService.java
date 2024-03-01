// UserService.java
package org.example.Entities;

import org.example.Entities.Users;
import java.util.List;

public interface UserService {
    Users addUser(Users user);
    void deleteUser(Long id);
    Users updateUser(Long id, Users newUser);
    List<Users> getAllUsers(); // Добавленный метод для получения всех пользователей
}
