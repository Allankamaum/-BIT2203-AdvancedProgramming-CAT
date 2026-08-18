package com.jkuat.cat.q7;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.List;

public class BookController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        BookDAO dao = new BookDAO();
        List<Book> books = dao.getAllBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("bookList.jsp").forward(req, res);
    }
}