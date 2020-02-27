package by.it.academy.ob.service.Impl;

import by.it.academy.ob.dao.UserDAO;
import by.it.academy.ob.dao.impl.uses.UserDaoImpl;
import by.it.academy.ob.model.User;
import by.it.academy.ob.service.User2Interface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class User2Impl implements User2Interface {
    private static final UserDAO userDAO = UserDaoImpl.getiNSTANCE();
    private static final Logger logger = LoggerFactory.getLogger(User2Impl.class);
    private static final User2Interface INSTANCE = new User2Impl();


    private User2Impl() {
    }

    public static User2Interface getInstance() {
        return INSTANCE;
    }

    @Override
    public User findUser(String username, String password) {
        logger.debug("find user by username and password");
        try {
            Optional<User> optionalUser = userDAO.findByUsername(username);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }
//            logger.debug("result" + optionalUser);
        } catch (Exception e) {
            e.printStackTrace();
//            logger.error("error while finding user by username and password" + e);
        }
        return null;
    }

    @Override
    public Optional<User> findExist(String username) {
        Optional<User> users = null;
        try {
            users = userDAO.findByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (users.isPresent()) {
            User user = users.get();
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public void create(User user) {
        try {
            Long id = userDAO.add(user);
            user.setId(id);
        } catch (SQLException e) {
            logger.error("======Error ADD USER from SERVICE======= ");
        }
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try {
            list = userDAO.getAll();
        } catch (SQLException e) {
            logger.error("=======Error Get All User from Service======");
        }
        return list;
    }
}
