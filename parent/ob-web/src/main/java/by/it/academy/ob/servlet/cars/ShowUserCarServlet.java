package by.it.academy.ob.servlet.cars;

import by.it.academy.ob.service.Impl.car.MakeImpl;
import by.it.academy.ob.service.Impl.car.ModelImpl;
import by.it.academy.ob.service.MakeInterface;
import by.it.academy.ob.service.ModelInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/userCar")
public class ShowUserCarServlet extends HttpServlet {
    private ModelInterface instModel = ModelImpl.getInstance();
    private MakeInterface instMake = MakeImpl.getInstanse();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
