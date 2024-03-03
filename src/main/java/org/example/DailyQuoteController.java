package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Daily")
public class DailyQuoteController {

    private final UserService userService;
    private final DailyQuoteService dailyQuoteService;

    @Autowired
    public DailyQuoteController(UserService userService, DailyQuoteService dailyQuoteService) {
        this.userService = userService;
        this.dailyQuoteService = dailyQuoteService;
    }

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUser) {
        User updatedUser = userService.updateUser(id, newUser);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/dailyquote/{mood}")
    public String getDailyQuote(@PathVariable String mood) {
        return "<html><head><title>Daily Quote Service</title></head><body>"
                + "<h1>Daily Quote of " + mood + "</h1>"
                + "<p>" + dailyQuoteService.getRandomQuote(mood) + "</p>"
                + "</body></html>";
    }
    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
