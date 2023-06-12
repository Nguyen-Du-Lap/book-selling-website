package vn.edu.hcmuaf.fit.controller.adminRoot;

import vn.edu.hcmuaf.fit.filter.MaintenanceFilter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "enable-maintenance", value = "/admin-root-enable-maintenance")
public class MaintenanceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintenanceFilter.maintenanceMode = !MaintenanceFilter.maintenanceMode;
        response.sendRedirect(request.getHeader("Referer"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
