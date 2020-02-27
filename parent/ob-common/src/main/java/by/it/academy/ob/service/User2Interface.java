package by.it.academy.ob.service;

import by.it.academy.ob.model.User;

import java.util.List;
import java.util.Optional;

public interface User2Interface {
    Optional<User> findExist(String username);
    User findUser(String username, String password);
    void create(User user);
    List<User> getAll();
}
