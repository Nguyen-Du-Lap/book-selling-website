package vn.edu.hcmuaf.fit.controller.admin.managementWeb;

import vn.edu.hcmuaf.fit.dao.IManagementWebDAO;
import vn.edu.hcmuaf.fit.services.IWebManagementService;
import vn.edu.hcmuaf.fit.services.impl.WebManagementService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//@MultipartConfig
@WebServlet(name = "admin-add-management-web", value = "/admin-root-add-management-web")
public class AddWebController extends HttpServlet {
    IWebManagementService iWebManagementService = new WebManagementService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");
        if( message != null && alert != null) {
            request.setAttribute("message", message);
            request.setAttribute("alert", alert);
        }
        request.getRequestDispatcher("views/admin_root/form-add-web.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String nameWebsite = request.getParameter("nameWebsite");
            String content = request.getParameter("contentCK");
            iWebManagementService.saveWebManagement("name", "nameWebsite", "Thong Tin");
            response.sendRedirect("/admin-root-add-management-web");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
