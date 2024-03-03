package org.example.DailyQuotes;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "clients")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private boolean gender;
}
