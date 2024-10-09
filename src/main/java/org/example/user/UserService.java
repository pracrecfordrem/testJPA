package org.example.user;

import lombok.Getter;
import org.example.ItemRepository;
import org.example.exception.NotFoundException;
import org.example.itemnote.ItemNoteRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Getter
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final ItemNoteRepository itemNoteRepository;

    public UserService(UserRepository userRepository, ItemRepository itemRepository, ItemNoteRepository itemNoteRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.itemNoteRepository = itemNoteRepository;
    }

    public User saveUser(UserDto userDto){
        return userRepository.save(UserMapper.toUser(userDto));
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("Not found"));
    }

    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }
}
