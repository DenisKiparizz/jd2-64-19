package by.it.academy.ob.service;

import by.it.academy.ob.model.User;

import java.util.Optional;

public interface UserInterface {
     Optional<User> getUser(String name, String password);

}
