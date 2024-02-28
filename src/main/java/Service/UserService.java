package Service;

import org.example.Entities.Users;
import org.example.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public Users createUser(String name, String surname, boolean gender) {
        Users newUser = new Users();
        newUser.setName(name);
        newUser.setSurname(surname);
        newUser.setGender(gender);
        return usersRepository.save(newUser);
    }
}
