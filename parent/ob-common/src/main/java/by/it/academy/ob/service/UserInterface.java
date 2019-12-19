package by.it.academy.ob.service;

import by.it.academy.ob.model.User;

import java.util.Optional;

public interface UserInterface {
     User getUser(String name, String password);

}
