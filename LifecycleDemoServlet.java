import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class LifecycleDemoServlet extends HttpServlet {

    public void init() {
        System.out.println("LOG: init() called - servlet initialized");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("LOG: service() -> doGet() called");
        res.getWriter().println("Servlet is handling a GET request");
    }

    public void destroy() {
        System.out.println("LOG: destroy() called - servlet shutting down");
    }
}