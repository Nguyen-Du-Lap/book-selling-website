package vn.edu.hcmuaf.fit.controller.adminRoot;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "admin-management-web", value = "/admin-root-management-web")
public class ManagementWebController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Giới Thiệu Về Doraemon");
        request.getRequestDispatcher("views/admin_root/management-web.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
