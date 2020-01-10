package by.it.academy.ob.servlet;

import by.it.academy.ob.model.Services;
import by.it.academy.ob.service.ServicesInterface;
import by.it.academy.ob.service.iml.ServicesIML;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/listService")
public class ListServicesServlet extends HttpServlet {
    private ServicesInterface instance = ServicesIML.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Services> list1 = instance.ListServices();
        req.setAttribute("listService",list1);
        req.getRequestDispatcher("/WEB-INF/jsp/serviceList.jsp").forward(req,resp);
    }
}
