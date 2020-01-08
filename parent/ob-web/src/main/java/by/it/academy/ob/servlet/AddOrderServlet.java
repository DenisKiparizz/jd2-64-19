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

@WebServlet(urlPatterns = "/addOrder")
public class AddOrderServlet extends HttpServlet {
    private CarsDAO serv = CarsDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/addAllInformationAboutCar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("make");
        String model = req.getParameter("model");
        String body = req.getParameter("body");
        String typeOfEngine = req.getParameter("typeOfEngine");
        String age = req.getParameter("age");
        String valueOfEngine = req.getParameter("valueOfEngine");
        Cars car = new Cars(name, model,body, typeOfEngine, Double.valueOf(valueOfEngine), Long.valueOf(age),
                null);
        try {
            serv.add(car);
            resp.sendRedirect(req.getContextPath() + "/list");
        } catch (SQLException e) {
            req.getRequestDispatcher("/WEB-INF/jsp/addAllInformationAboutCar.jsp").forward(req, resp);
        }



    }
}
