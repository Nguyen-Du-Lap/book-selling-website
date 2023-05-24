package vn.edu.hcmuaf.fit.controller.web.products;

import vn.edu.hcmuaf.fit.model.BookModel;
import vn.edu.hcmuaf.fit.services.IProductService;
import vn.edu.hcmuaf.fit.services.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/products/search", value = "/products/search")
public class ProductSearchController extends HttpServlet {
    IProductService iProductService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String key = request.getParameter("key");
        if(key != null) {
//            List<BookModel> list12Book
            request.setAttribute("list12Book", iProductService.find12BookSearch(key));
        }
        request.setAttribute("totalPage", iProductService.totalPage());
        request.setAttribute("currentPage", 1);
        request.getRequestDispatcher("/views/web/product.jsp").forward(request, response);
    }
}
