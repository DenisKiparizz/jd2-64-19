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

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    private final User2Interface register = User2Impl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");

//        User2 user = new User2(firstName, secondName, userName, password, repeatPassword);
        String error = " ";
        boolean er = false;

        if (firstName == null || firstName.length() == 0) {
            er = true;
            error = "First name is EMPTY";
        } else if (secondName == null || secondName.length() == 0) {
            er = true;
            error = "Second name is EMPTY";
        } else if (userName == null || userName.length() == 0) {
            er = true;
            error = "User name is EMPTY";
        } else if (password == null || password.length() == 0) {
            er = true;
            error = "Password name is EMPTY";
        } else if (!(password.equals(repeatPassword))) {
            er = true;
            error = "Input second password like first!!!";
        }

        if (er) {
            req.setAttribute("ErrorInput", error);
            req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req, resp);
        } else
            register.create(new User(firstName, secondName, userName, password,"user"));
        resp.sendRedirect(req.getContextPath() + "/homePage");

    }
}
