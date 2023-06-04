package vn.edu.hcmuaf.fit.controller.adminRoot.managementLog;

import vn.edu.hcmuaf.fit.services.ILogManagmentService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "admin-table-log", value = "/admin-root-table-log")
public class TableLogController extends HttpServlet {
    @Inject
    ILogManagmentService iLogManagmentService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // title dung de active aside
        request.setAttribute("title", "Danh Sách Log");
        request.setAttribute("listLog", iLogManagmentService.getAll());

        String message = request.getParameter("message");
        String alert = request.getParameter("alert");

        if(message != null & alert != null) {
            request.setAttribute("message", message);
            request.setAttribute("alert", alert);
        }
        request.getRequestDispatcher("views/admin_root/table-data-log.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
