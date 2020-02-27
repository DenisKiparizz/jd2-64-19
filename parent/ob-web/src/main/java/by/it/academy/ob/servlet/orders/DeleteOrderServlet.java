package by.it.academy.ob.servlet.orders;

import by.it.academy.ob.service.Impl.OrderOmpl;
import by.it.academy.ob.service.OrderInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteOrder")
public class DeleteOrderServlet extends HttpServlet {
    private OrderInterface inst = OrderOmpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        inst.deleteOrder(id);
        resp.sendRedirect(req.getContextPath() + "/ordersList");

    }
}
