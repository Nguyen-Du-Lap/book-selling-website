package vn.edu.hcmuaf.fit.controller.admin;

import vn.edu.hcmuaf.fit.services.IContactService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "admin-management-contact", value = "/admin-management-contact")
public class ManagementContactController extends HttpServlet {
    @Inject
    IContactService iContactService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Quản lý contact");
        request.setAttribute("listContact", iContactService.findAllContact());
        request.getRequestDispatcher("views/admin/management-contact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
