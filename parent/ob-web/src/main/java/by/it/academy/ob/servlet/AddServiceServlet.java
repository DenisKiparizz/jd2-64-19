package by.it.academy.ob.servlet;

import by.it.academy.ob.model.Model;
import by.it.academy.ob.service.ServiceInterface;
import by.it.academy.ob.service.ServiceLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/add")
public class AddServiceServlet extends HttpServlet {
    private ServiceInterface service = ServiceLogic.getService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/car_service_orders/addService.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameOfService");
        String description = req.getParameter("description");
        String id = req.getParameter("id");

        Model model = new Model(name,description,null);

        service.addNewService(model);
        resp.sendRedirect(req.getContextPath()+"/list");

    }
}
