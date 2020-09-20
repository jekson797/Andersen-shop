package by.andersenlab.shop.servlets.product_adding;

import by.andersenlab.shop.dao.PhoneDao;
import by.andersenlab.shop.dao.ProductDao;
import by.andersenlab.shop.enums.Currency;
import by.andersenlab.shop.products.PhoneProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/add-product/phone")
public class AddPhoneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add-phone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PhoneProduct phone = buildPhoneFromRequest(req);
        boolean savingResult = savePhoneToDatabase(phone);
        if (savingResult) {
            req.getRequestDispatcher("/successful-adding.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/unsuccessful-adding.jsp").forward(req, resp);
        }
    }

    private boolean savePhoneToDatabase(PhoneProduct product) {
        ProductDao productDao = new ProductDao();
        PhoneDao phoneDao = new PhoneDao();
        return productDao.save(product) && phoneDao.save(product);
    }

    private PhoneProduct buildPhoneFromRequest(HttpServletRequest req) {
        return new PhoneProduct.PhoneBuilder().
                buildBrand(req.getParameter("brand")).
                buildModel(req.getParameter("model")).
                buildOs(req.getParameter("os")).
                buildMemorySize(Integer.parseInt(req.getParameter("memorySize"))).
                buildRam(Integer.parseInt(req.getParameter("ram"))).
                buildCoreNumbers(Integer.parseInt(req.getParameter("coresNumber"))).
                buildDiagonal(Double.parseDouble(req.getParameter("diagonal"))).
                buildPrice(new BigDecimal(req.getParameter("price"))).
                buildCurrency(Currency.valueOf(req.getParameter("currency").toUpperCase())).
                build();
    }
}
