package vn.edu.hcmuaf.fit.controller.adminRoot;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "admin-management-user", value = "/admin-root-management-user")
public class ManagementUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // title dung de active aside
        request.setAttribute("title", "Danh Sách Nhân Viên");
        request.getRequestDispatcher("/views/admin_root/management-user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}