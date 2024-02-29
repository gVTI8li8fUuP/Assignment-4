package Service;

import org.example.Entities.Users;
import org.example.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody Users user) {
        usersRepository.save(user);
        return ResponseEntity.ok("User added successfully");
    }
}
