package vn.edu.hcmuaf.fit.controller.admin.managementProduct;

import vn.edu.hcmuaf.fit.services.IBookManagementService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "update-book", value = "/update-book")
public class UpdateProductController extends HttpServlet {
    @Inject
    IBookManagementService iBookManagementService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        try {
            int i = iBookManagementService.update(id, name, quantity, price);
            if(i >= 1) {
                response.sendRedirect("/admin-table-product");
            }else {
                request.getRequestDispatcher("/views/admin/table-data-product.jsp").forward(request, response);
            }
        }catch (Exception e) {
            request.getRequestDispatcher("/views/admin/table-data-product.jsp").forward(request, response);
        }

    }
}
