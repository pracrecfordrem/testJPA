package org.example.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
public class UserDto {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String registrationDate;
    private UserState state;

    public UserDto() {
    }
}
