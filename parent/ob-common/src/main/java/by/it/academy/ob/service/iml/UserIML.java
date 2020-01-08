package by.it.academy.ob.service.iml;

import by.it.academy.ob.model.User;
import by.it.academy.ob.service.UserInterface;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserIML implements UserInterface {
    private static final UserInterface INSTANCE = new UserIML();
    private final Map<String, User> usersList = new ConcurrentHashMap<>();
    private AtomicLong id = new AtomicLong();

    public UserIML()
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
