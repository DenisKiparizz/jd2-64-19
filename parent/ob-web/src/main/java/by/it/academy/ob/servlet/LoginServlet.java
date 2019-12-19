package by.it.academy.ob.servlet;

import by.it.academy.ob.model.User;
import by.it.academy.ob.service.UserInterface;
import by.it.academy.ob.service.UserLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    private final UserInterface userService = new UserLogic().getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String password = req.getParameter("password");
        User user = new User(name, password);

        String errorMassage = "";
        boolean error = false;
        if (name == null || name.length() == 0 || password == null || password.length() == 0) {
            error = true;
            errorMassage = "Empty USERNAME and PASSWORD";
        } else {
            User user1 = userService.getUser(name,password);
            if (user1==null) {
                error = true;
                errorMassage = "Wrong EMAIL or PASSWORD. Try one more time";
            } else {
                req.getSession().setAttribute("user", user1);
            }

        }
        if (error) {
            req.setAttribute("Error", errorMassage);
            //userName
            req.setAttribute("user", new User(name, password));
            //userName
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);

        } else
            resp.sendRedirect(req.getContextPath()+"/home");

    }
}
