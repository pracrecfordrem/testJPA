package org.example.user;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public User saveUser(UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{userId}")
    public User getAllUsers(@PathVariable Long userId) {
        return userService.getUser(userId);
    }
}
