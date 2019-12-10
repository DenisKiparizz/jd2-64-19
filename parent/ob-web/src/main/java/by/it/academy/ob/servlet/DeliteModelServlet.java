package by.it.academy.ob.servlet;

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


@WebServlet(urlPatterns = "/dell")
public class DeliteModelServlet extends HttpServlet {
    private ServiceInterface service = ServiceLogic.getService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/showListServices.jsp").forward(req,resp);
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        service.deliteService1(id);
        resp.sendRedirect(req.getContextPath()+"/list");
    }
}
