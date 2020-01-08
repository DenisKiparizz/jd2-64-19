package by.it.academy.ob.servlet;

import by.it.academy.ob.dao.CarsDAO;
import by.it.academy.ob.dao.impl.CarsDao;
import by.it.academy.ob.model.Cars;
import by.it.academy.ob.service.CarsInterface;
import by.it.academy.ob.service.iml.CarsIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/list")
public class ListCarsServlet extends HttpServlet {
    private CarsInterface cars = CarsIml.getInstance();
    private CarsDAO service = CarsDao.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cars> list = null;
        try {
            list = service.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("list",list);
        req.getRequestDispatcher("/WEB-INF/jsp/carsList.jsp").forward(req, resp);


    }
}
