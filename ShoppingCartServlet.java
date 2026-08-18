import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ShoppingCartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        String item = req.getParameter("item");
        cart.add(item);
        res.getWriter().println("Item added: " + item);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        List<String> cart = session != null ? (List<String>) session.getAttribute("cart") : null;
        res.getWriter().println("Cart contents: " + (cart != null ? cart : "empty"));
    }
}