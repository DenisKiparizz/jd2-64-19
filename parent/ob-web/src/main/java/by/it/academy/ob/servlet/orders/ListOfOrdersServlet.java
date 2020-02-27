package by.it.academy.ob.servlet.orders;

import by.it.academy.ob.model.car_services.Order;
import by.it.academy.ob.service.Impl.OrderOmpl;
import by.it.academy.ob.service.OrderInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ordersList")
public class ListOfOrdersServlet extends HttpServlet {
    private OrderInterface inst = OrderOmpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = inst.getAll();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("WEB-INF/jsp/order_list.jsp").forward(req, resp);
    }
}
