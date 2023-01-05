package vn.edu.hcmuaf.fit.controller.admin.managementProduct;

import vn.edu.hcmuaf.fit.dao.IBookManagementDAO;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "admin-add-san-pham", value = "/admin-add-san-pham")
public class AddProductController extends HttpServlet {
    @Inject
    IBookManagementDAO iBookManagementDAO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCatalog", iBookManagementDAO.listCatalog());
        request.setAttribute("listPublisherCompany", iBookManagementDAO.listPublisherCompany());
        request.getRequestDispatcher("views/admin/form-add-san-pham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
