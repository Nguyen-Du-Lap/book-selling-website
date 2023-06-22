package vn.edu.hcmuaf.fit.controller.adminRoot;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.filter.MaintenanceFilter;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet(name = "enable-maintenance", value = "/admin-root-enable-maintenance")
public class MaintenanceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintenanceFilter.maintenanceMode = !MaintenanceFilter.maintenanceMode;
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        Log log = new Log(Log.WARNING,ip,"Admin", cus.getIdUser(), "Bảo trì hệ thống",1);
        log.insert();
        response.sendRedirect(request.getHeader("Referer"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
