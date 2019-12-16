package by.it.academy.ob.service;

import by.it.academy.ob.model.User;


import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserLogic implements UserInterface {

private static final UserInterface INSTANCE = new UserLogic();
private Map<String, User> userList = new ConcurrentHashMap<>();

public UserLogic(){
    userList.put("Admin",new User("Admin","12345","admin"));
    userList.put("User",new User("User","54321","user"));
}

public UserInterface getInstance(){
    return INSTANCE;
}

    @Override
    public Optional<User> getUser(String name, String password) {
        User user = userList.get(name);
        if (user != null && password.equals(user.getPassword())) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
}

}
