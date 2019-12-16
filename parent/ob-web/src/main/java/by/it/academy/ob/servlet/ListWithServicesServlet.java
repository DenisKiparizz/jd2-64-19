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
import java.util.List;

@WebServlet(urlPatterns = "/list")
public class ListWithServicesServlet extends HttpServlet {
    private ServiceInterface service = ServiceLogic.getService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Model> allModels =service.getListServices();
        req.setAttribute("list",allModels);
        req.getRequestDispatcher("/WEB-INF/jsp/car_service_orders/showListServices.jsp").forward(req,resp);
    }
}
