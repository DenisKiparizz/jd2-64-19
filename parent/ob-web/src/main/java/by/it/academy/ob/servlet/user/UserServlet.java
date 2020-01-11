package by.it.academy.ob.servlet.user;

import by.it.academy.ob.model.User;
import by.it.academy.ob.service.UserInterface;
import by.it.academy.ob.service.Impl.UserImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class UserServlet extends HttpServlet {
    private final UserInterface userInterface = new UserImpl().getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new User(name, password);

        String errorMsg = "";
        boolean error = false;

        if (name == null || name.length() == 0 || password == null || password.length() == 0) {
            error = true;
            errorMsg = "Empty USERNAME and PASSWORD";
        } else {
            User user1 = userInterface.getUser(name, password);
            if (user1 == null) {
                error = true;
                errorMsg = "Wrong EMAIL or PASSWORD. Try one more time";
            } else {
                req.getSession().setAttribute("user", user1);
            }
        }
        if (error) {
            req.setAttribute("ERROR666", errorMsg);
            req.setAttribute("user", new User(name, "password"));
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        } else
            resp.sendRedirect(req.getContextPath() + "/homePage");
    }
}
