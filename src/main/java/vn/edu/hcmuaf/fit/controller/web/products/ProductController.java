package vn.edu.hcmuaf.fit.controller.web.products;

import vn.edu.hcmuaf.fit.constant.SystemConstant;
import vn.edu.hcmuaf.fit.model.BookModel;
import vn.edu.hcmuaf.fit.model.CatalogModel;
import vn.edu.hcmuaf.fit.services.ICatalogService;
import vn.edu.hcmuaf.fit.services.IProductService;
import vn.edu.hcmuaf.fit.services.impl.ProductService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "product", value = "/products")
public class ProductController extends HttpServlet {

    IProductService iProductService = new ProductService();
    int pageCurrent = 1;
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page != null) {
            int pageInt = Integer.parseInt(page);
            pageCurrent = pageInt;

            request.setAttribute("currentPage", pageInt);
            request.setAttribute("list12Book", iProductService.findAllLimitOffsetService(pageInt));
        }else {
            request.setAttribute("currentPage", 1);
            request.setAttribute("list12Book", iProductService.find12Product());
        }


        request.setAttribute("totalPage", iProductService.totalPage());
        request.getRequestDispatcher("/views/web/product.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
