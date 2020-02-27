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

@WebServlet(urlPatterns = "/login")
public class UserServlet extends HttpServlet {
    private  User2Interface userInterface = User2Impl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("password");

        String errorMassage = "";
        boolean error = false;

        if (username == null || username.length() == 0) {
            error = true;
            errorMassage = "Empty username";
        } else if (password == null || password.length() == 0) {
            error = true;
            errorMassage = "Empty password";
        } else {
            User user = userInterface.findUser(username, password);
            if (user ==null) {
                error = true;
                errorMassage = "Dont have this one";
            } else {
                req.getSession().setAttribute("user", user);
            }
        }
        if (error) {
            req.setAttribute("ERROR666", errorMassage);
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        } else
            resp.sendRedirect(req.getContextPath() + "/homePage");
    }
}
