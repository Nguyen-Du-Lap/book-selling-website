package vn.edu.hcmuaf.fit.controller.admin.managementProduct;

import vn.edu.hcmuaf.fit.dao.IBookManagementDAO;
import vn.edu.hcmuaf.fit.model.BookManagementModel;
import vn.edu.hcmuaf.fit.services.IBookManagementService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "findProduct", value = "/findProduct")
public class FindProductController extends HttpServlet {
    @Inject
    IBookManagementService iBookManagementService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if(id != null) {
            List<BookManagementModel> list = new ArrayList<>();
            list.add(iBookManagementService.findById(id));
            request.setAttribute("bookUpdate", list);
            request.getRequestDispatcher("/views/admin/table-data-product-update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
