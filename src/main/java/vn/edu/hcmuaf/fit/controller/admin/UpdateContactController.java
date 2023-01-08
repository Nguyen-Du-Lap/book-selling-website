package vn.edu.hcmuaf.fit.controller.admin;

import vn.edu.hcmuaf.fit.services.IContactService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "update-contact", value = "/update-contact")
public class UpdateContactController extends HttpServlet {
    @Inject
    IContactService iContactService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");
        if (message != null && alert != null) {
            request.setAttribute("message", message);
            request.setAttribute("alert", alert);
        }
        request.getRequestDispatcher("views/admin/management-contact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");
        int statusInt = 0;
        if (status.equalsIgnoreCase("Đã đọc")) {
            statusInt = 1;
        } else {
            statusInt =0;
        }
            try {
                int i = iContactService.update(id, 0);
                if (i >= 1) {
                    response.sendRedirect("/admin-management-contact?message=Upload success&alert=success");
                } else {
                    response.sendRedirect("/admin-management-contact?message=Upload error&alert=danger");
                }
            } catch (Exception e) {
                response.sendRedirect("/admin-management-contact?message=Upload error&alert=danger");            }
    }

}
