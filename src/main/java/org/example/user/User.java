package org.example.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    @NonNull
    @Column(name = "first_name")
    private String firstName;
    @NonNull
    @Column(name = "last_name")
    private String lastName;
    private LocalDateTime registrationDate;
    private String state;

    public User() {
    }

    public User(String email, @NonNull String firstName, @NonNull String lastName, LocalDateTime registrationDate, String state) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
        this.state = state;
    }
}
