package vn.edu.hcmuaf.fit.controller.admin.managementProduct;

import vn.edu.hcmuaf.fit.services.IBookManagementService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = { "/deleteProduct"})
public class DeleteProductController extends HttpServlet {
    @Inject
    IBookManagementService bookManagement;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id != null) {
            int idInt = Integer.parseInt(id);
            bookManagement.deleteById(idInt);
            response.sendRedirect(request.getContextPath()+"/admin-table-product");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}