package vn.edu.hcmuaf.fit.controller.admin.managementCustomer;

import vn.edu.hcmuaf.fit.services.ICustomerService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "update-customer", value = "/update-customer")
public class UpdateCustomerController extends HttpServlet {
    @Inject
    ICustomerService iCustomerService;
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
        request.getRequestDispatcher("views/admin/table-data-customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        try {
            int i = iCustomerService.update(idUser, firstName, lastName, phone, address);
            if(i >= 1) {
                response.sendRedirect("/admin-table-customer?message=Upload success&alert=success");
            }else {
                response.sendRedirect("/admin-table-customer?message=Upload error&alert=error");
            }
        } catch (Exception e) {
            request.getRequestDispatcher("views/admin/table-data-customer.jsp").forward(request, response);
        }
    }
}
