package by.it.academy.ob.servlet;

import by.it.academy.ob.dao.MakeDAO;
import by.it.academy.ob.dao.impl.car.MakeImplDAO;
import by.it.academy.ob.model.cars.Make;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet(urlPatterns = "/fuck")
public class MakeListServlet extends HttpServlet {
    private MakeDAO inc = MakeImplDAO.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Make> list = null;
        try {
            list = inc.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/jsp/fuck.jsp").forward(req, resp);
    }
}
