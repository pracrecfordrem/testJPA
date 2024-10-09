package org.example.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface UserRepository extends CrudRepository<User, Long> {
    //UserShort userShort();
    List<User> findByEmailContainingIgnoreCase(String emailSearch);
    List<UserShort> findAllByEmailContainingIgnoreCase(String emailSearch);
}
