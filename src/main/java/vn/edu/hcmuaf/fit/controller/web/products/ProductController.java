package vn.edu.hcmuaf.fit.controller.web.products;

import vn.edu.hcmuaf.fit.constant.SystemConstant;
import vn.edu.hcmuaf.fit.model.CatalogModel;
import vn.edu.hcmuaf.fit.services.ICatalogService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "product", value = "/products")
public class ProductController extends HttpServlet {
    @Inject
    ICatalogService catalogService;
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CatalogModel model = new CatalogModel();
        model.setTotalCard(catalogService.findAll().size());
//        request.setAttribute(SystemConstant.MODEL, model);
        request.getRequestDispatcher("/views/web/product.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
