package org.example.user;

import java.time.LocalDateTime;

public class UserMapper {
    public static User toUser(UserDto userDto) {

        return new User(
                userDto.getId(),
                userDto.getEmail(),
                userDto.getFirstName(),
                userDto.getLastName(),
                LocalDateTime.now(),
                "ACTIVE"
        );
    }
}
