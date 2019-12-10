package by.it.academy.ob.servlet;

import by.it.academy.ob.model.Model;
import by.it.academy.ob.model.Model;
import by.it.academy.ob.service.ServiceInterface;
import by.it.academy.ob.service.ServiceLogic;
import by.it.academy.ob.service.ServiceInterface;
import by.it.academy.ob.service.ServiceLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    private ServiceInterface service = ServiceLogic.getService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameOfService");
        String description = req.getParameter("description");
        String id = req.getParameter("id");
        Model model = new Model(name, description, null);
        service.update(model);
//      resp.sendRedirect(req.getContextPath() + "/list");

    }
}
