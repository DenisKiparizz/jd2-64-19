package by.it.academy.ob.servlet.user;

import by.it.academy.ob.model.User;
import by.it.academy.ob.service.Impl.User2Impl;
import by.it.academy.ob.service.User2Interface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/usersList")
public class UsersListServlet extends HttpServlet {
    private User2Interface register = User2Impl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> usersList = register.getAll();
        req.setAttribute("usersList", usersList);
        req.getRequestDispatcher("/WEB-INF/jsp/usersList.jsp").forward(req, resp);
    }
}
