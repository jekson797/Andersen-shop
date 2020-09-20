package by.andersenlab.shop.servlets;

import by.andersenlab.shop.dao.ProductDao;
import by.andersenlab.shop.products.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class CatalogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/catalog.jsp").forward(req, resp);
    }
}
