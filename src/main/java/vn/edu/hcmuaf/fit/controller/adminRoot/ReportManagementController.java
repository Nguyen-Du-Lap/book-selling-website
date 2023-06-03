package vn.edu.hcmuaf.fit.controller.adminRoot;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "admin-report-management", value = "/admin-root-report-management")
public class ReportManagementController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // title dung de active aside
        request.setAttribute("title", "Báo Cáo Doanh Thu");
        request.getRequestDispatcher("views/admin_root/report-management.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
