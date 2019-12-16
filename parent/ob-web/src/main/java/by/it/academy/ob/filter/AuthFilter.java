package by.it.academy.ob.filter;

import by.it.academy.ob.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter(urlPatterns = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class AuthFilter extends HttpFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();

        logger.debug("url: {}", req.getRequestURI());

      Optional<User> user = (Optional<User>) session.getAttribute("user");

//        User user = (User) session.getAttribute("user");

        if (user == null
                && !req.getRequestURI().endsWith("/")
                && !req.getRequestURI().endsWith("/home")
                && !req.getRequestURI().endsWith("/login")) {
            resp.sendRedirect(req.getContextPath() + "/login");

        } else {
            super.doFilter(req, resp, chain);
        }
    }
}
