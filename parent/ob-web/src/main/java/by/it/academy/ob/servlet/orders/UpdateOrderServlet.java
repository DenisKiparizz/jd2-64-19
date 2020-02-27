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
import java.util.Optional;

@WebServlet(urlPatterns = "/updateOrder")
public class UpdateOrderServlet extends HttpServlet {
    private OrderInterface inst = OrderOmpl.getInstance();
    private ServiceTypeInterface instService = ServiceTypeImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long orderID = Long.valueOf(req.getParameter("id"));
        Optional<Order> orderById = inst.findByID(orderID);
        Order order = orderById.orElseThrow(() -> new RuntimeException("Havent exist"));

        req.setAttribute("serviceID", order.getServiceType_id());
        req.setAttribute("title", order.getTitle());
        req.setAttribute("services", instService.getAllServices());
        req.setAttribute("description", order.getDescription());
        req.getRequestDispatcher("WEB-INF/jsp/update_order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));

        String service_type_id = req.getParameter("serviceID");
        ServiceT serviceT = instService.getAllServices().stream().
                filter(service111 -> service111.getId().equals(Long.valueOf(service_type_id))).findFirst().orElseThrow(() -> new RuntimeException("Not service" +
                "with this id" + service_type_id));
        String title = req.getParameter("title");
        String describtion = req.getParameter("description");

        Order orderNew = new Order(id, title, serviceT, describtion);
        inst.update(orderNew);
        resp.sendRedirect(req.getContextPath() + "/ordersList");
    }
}
