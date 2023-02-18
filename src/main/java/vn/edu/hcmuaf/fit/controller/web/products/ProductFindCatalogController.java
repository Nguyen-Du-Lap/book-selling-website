package vn.edu.hcmuaf.fit.controller.web.products;

import vn.edu.hcmuaf.fit.services.IProductService;
import vn.edu.hcmuaf.fit.services.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "products/catalogs", value = "/products/catalogs")
public class ProductFindCatalogController extends HttpServlet {
    IProductService iProductService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCatalog = request.getParameter("id");
        if(idCatalog != null) {
            int idInt = Integer.parseInt(idCatalog);
            request.setAttribute("title", "Danh mục");
            request.setAttribute("list12Book", iProductService.find12BookCatalog(idInt));
        }
        request.setAttribute("totalPage", iProductService.totalPage());
        request.setAttribute("currentPage", 1);
        request.getRequestDispatcher("/views/web/product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
