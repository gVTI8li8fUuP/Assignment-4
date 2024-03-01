// UsersServiceImpl.java
package org.example.Entities;

import org.example.Entities.UserService;
import org.example.Entities.Users;
import org.springframework.beans.factory.annotation.Qualifier;
import org.example.Entities.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersServiceImpl implements UserService {

    @Qualifier("customusersRepository")
    private UsersRepository UsersRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users addUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Users updateUser(Long id, Users newUser) {
        if (usersRepository.existsById(id)) {
            newUser.setId(id);
            return usersRepository.save(newUser);
        } else {
            return null; // или выбросить исключение, если пользователь не найден
        }
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll(); // Реализация метода для получения всех пользователей
    }

}
