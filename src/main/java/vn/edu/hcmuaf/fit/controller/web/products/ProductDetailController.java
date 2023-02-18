package vn.edu.hcmuaf.fit.controller.web.products;

import vn.edu.hcmuaf.fit.dao.IProductDAO;
import vn.edu.hcmuaf.fit.dao.IRateDAO;
import vn.edu.hcmuaf.fit.dao.impl.ProductDAO;
import vn.edu.hcmuaf.fit.dao.impl.RateDAO;
import vn.edu.hcmuaf.fit.services.IProductService;
import vn.edu.hcmuaf.fit.services.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "product-detail", value = "/products/product-detail")
public class ProductDetailController extends HttpServlet {
    IProductService iProductService = new ProductService();
    IProductDAO productDAO = new ProductDAO();
    IRateDAO iRateDAO = new RateDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id != null) {
            int idInt = Integer.parseInt(id);
            request.setAttribute("bookModel" , iProductService.findBookDetailById(idInt));
            request.setAttribute("bookDetail", iProductService.findBookDetail1ById(idInt));
            request.setAttribute("listImage", iProductService.findAllImage(idInt));
            request.setAttribute("rates", iRateDAO.listRate(idInt));
            request.setAttribute("quantityRemain", productDAO.getRemainQuantity(idInt));
        }
        request.getRequestDispatcher("/views/web/product_detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
