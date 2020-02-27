package by.it.academy.ob.servlet.cars;

import by.it.academy.ob.model.cars.Model;
import by.it.academy.ob.service.Impl.car.ModelImpl;
import by.it.academy.ob.service.ModelInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/allCarModel")
public class CarsListServlet extends HttpServlet {
    private ModelInterface inst = ModelImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Model> list = inst.allCars();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/WEB-INF/jsp/cars/all_models_car.jsp").forward(req, resp);
    }
}
