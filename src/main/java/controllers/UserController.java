package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    public String getAllUsers() {

        return "Getting all users...";
    }

    public String getUser(int id) {

        return "Getting user with ID: " + id;
    }

    public String createUser(String name, String surname, String gender) {

        return "Creating user: " + name + " " + surname + " (" + gender + ")";

    }

}
