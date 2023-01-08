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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");
        if(message != null && alert!= null) {
            request.setAttribute("message", message);
            request.setAttribute("alert", alert);
        }
        request.getRequestDispatcher("views/admin/table-data-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        try {
            int i = iBookManagementService.update(idInt, name, quantity, price, discount);
            if(i >= 1) {
                response.sendRedirect("/admin-table-product?message=Upload success&alert=success");
            }else {
                response.sendRedirect("/admin-table-product?message=Upload success&alert=success");
            }
        }catch (Exception e) {
            request.getRequestDispatcher("/views/admin/table-data-product.jsp").forward(request, response);
        }

    }
}