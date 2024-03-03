package org.example.DailyQuotes;

import org.example.DailyQuotes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findBySurname(String surname);
}
