package vn.edu.hcmuaf.fit.controller.web.cart;

import vn.edu.hcmuaf.fit.dao.IProductDAO;
import vn.edu.hcmuaf.fit.dao.impl.ProductDAO;
import vn.edu.hcmuaf.fit.model.Cart;
import vn.edu.hcmuaf.fit.model.Product;
import vn.edu.hcmuaf.fit.services.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "add-to-cart", value = "/add-to-cart")
public class AddToCartController extends HttpServlet {
    private final IProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("product_id");
        if (productId != null) {
            Product product = productDAO.getProductById(Integer.parseInt(productId));
            int remainQuantity = productDAO.getRemainQuantity(product.getIdBook());

            Cart cart = (Cart) request.getSession().getAttribute("cart");
            if (cart == null) cart = new Cart();

            String action = request.getParameter("action");
            if (action != null) {
                switch (action) {
                    case "add":
                        String quantity = request.getParameter("quantity");
                        int qnt = quantity == null ? 1 : Integer.parseInt(quantity);

                        if (remainQuantity < qnt) {
                            break;
                        }

                        cart.addProduct(product, qnt);
                        productDAO.updateQuantity(product.getIdBook(), remainQuantity - qnt);
                        break;
                    case "remove":
                        cart.removeProduct(product);
                        productDAO.updateQuantity(product.getIdBook(), remainQuantity + 1);
                        break;
                    case "delete":
                        int deleteQuantities = cart.getMap().get(product.getIdBook()).getQuantity();
                        cart.deleteProduct(product);
                        productDAO.updateQuantity(product.getIdBook(), remainQuantity + deleteQuantities);
                        break;
                }
            }else if (remainQuantity >= 1) {
                cart.addProduct(product, 1);
                productDAO.updateQuantity(product.getIdBook(), remainQuantity - 1);
            }

            request.getSession().setAttribute("cart", cart);
            response.sendRedirect("cart");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
