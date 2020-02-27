package by.it.academy.ob.servlet.cars;

import by.it.academy.ob.model.cars.Body;
import by.it.academy.ob.model.cars.Car;
import by.it.academy.ob.model.cars.Make;
import by.it.academy.ob.model.cars.Model;
import by.it.academy.ob.service.*;
import by.it.academy.ob.service.Impl.ServiceTypeImpl;
import by.it.academy.ob.service.Impl.car.BodyImpl;
import by.it.academy.ob.service.Impl.car.CarImpl;
import by.it.academy.ob.service.Impl.car.MakeImpl;
import by.it.academy.ob.service.Impl.car.ModelImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/addMake")
public class AddCar extends HttpServlet {
    private ModelInterface instModel = ModelImpl.getInstance();
    private MakeInterface instMake = MakeImpl.getInstanse();
    private BodyInterface instBody = BodyImpl.getInstanse();
    private CarInterfaceSecond instCar = CarImpl.getInstanse();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("make", instMake.getAll());
        req.setAttribute("model", instModel.allCars());
        req.setAttribute("body", instBody.getAllBody());
        req.getRequestDispatcher("/WEB-INF/jsp/cars/add_car.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String make_id = req.getParameter("make_id");
        Make make = instMake.getAll().stream().filter(a -> a.getId().equals(Long.valueOf(make_id))).findFirst().orElseThrow(() -> new RuntimeException("Make"));
        String model_id = req.getParameter("model_id");
        Model model = instModel.allCars().stream().filter(a -> a.getId().equals(Long.valueOf(model_id))).findFirst().orElseThrow(() -> new RuntimeException("Model"));
        String body_id = req.getParameter("body_id");
        Body body = instBody.getAllBody().stream().filter(e -> e.getId().equals(Long.valueOf(body_id))).findFirst().orElseThrow(() -> new RuntimeException("Body"));
        Car car = new Car(null, make, model, body);
        instCar.addCar(car);
        req.getRequestDispatcher("/WEB-INF/jsp/homePage.jsp").forward(req, resp);


//        String makeID = req.getParameter("id");
//        Long id = Long.valueOf(makeID);
//        List<Model> model = instModel.getModelsByID(id);
//        req.setAttribute("model", model);
//        req.getRequestDispatcher("/WEB-INF/jsp/cars/add_model.jsp").forward(req, resp);
//        String modelID = req.getParameter("id");
//        Long idModel = Long.valueOf(makeID);
//        Optional<Model> userCar = instModel.getByID(idModel);
//        req.setAttribute("userCar", userCar);
//        resp.sendRedirect(req.getContextPath() + "/addMake");


    }
}
