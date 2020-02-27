package by.it.academy.ob.servlet.orders;

import by.it.academy.ob.model.car_services.Order;
import by.it.academy.ob.model.car_services.ServiceT;
import by.it.academy.ob.service.Impl.OrderOmpl;
import by.it.academy.ob.service.Impl.ServiceTypeImpl;
import by.it.academy.ob.service.OrderInterface;
import by.it.academy.ob.service.ServiceTypeInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/newOrder")
public class AddNewOrderServlet extends HttpServlet {

    private OrderInterface inst = OrderOmpl.getInstance();
    private ServiceTypeInterface instamceService = ServiceTypeImpl.getInstance();
    List<ServiceT> list = instamceService.getAllServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("services", instamceService.getAllServices());
        req.getRequestDispatcher("/WEB-INF/jsp/add_new_order.jsp").forward(req, resp);
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String service_type_id = req.getParameter("service_type_id");
        String description = req.getParameter("description");

        ServiceT serviceT = instamceService.getAllServices().stream().
                filter(service -> service.getId().equals(Long.valueOf(service_type_id))).findFirst().orElseThrow(() -> new RuntimeException("Not service" +
                "with this id" + service_type_id));
        Order order = new Order(null, title, serviceT, description);
        inst.addOrder(order);
        resp.sendRedirect(req.getContextPath() + "/homePage");


    }
}
