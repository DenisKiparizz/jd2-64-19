package by.it.academy.ob.service.Impl;

import by.it.academy.ob.model.User;
import by.it.academy.ob.service.UserInterface;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserImpl implements UserInterface {
    private static final UserInterface INSTANCE = new UserImpl();
    private final Map<String, User> usersList = new ConcurrentHashMap<>();
    private AtomicLong id = new AtomicLong();

    public UserImpl()
    {
        usersList.put("Admin", new User("Admin", "12345", "admin"));
        usersList.put("User", new User("User", "12345", "user"));

    }

    public UserInterface getInstance() {
        return INSTANCE;
    }
    @Override
    public User getUser(String name, String password) {
        User user = usersList.get(name);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
}
