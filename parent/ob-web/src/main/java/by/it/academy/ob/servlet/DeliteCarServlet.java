package by.it.academy.ob.servlet;

import by.it.academy.ob.dao.CarsDAO;
import by.it.academy.ob.dao.impl.CarsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/dellCar")
public class DeliteCarServlet extends HttpServlet {
    private static CarsDAO service = CarsDao.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        try {
            service.delete(id);
            resp.sendRedirect(req.getContextPath()+"/list");
        } catch (SQLException e) {
            req.getRequestDispatcher("").forward(req,resp);
        }

    }
}
