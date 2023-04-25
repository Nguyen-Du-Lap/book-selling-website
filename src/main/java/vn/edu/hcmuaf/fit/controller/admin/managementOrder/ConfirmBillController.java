package vn.edu.hcmuaf.fit.controller.admin.managementOrder;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IBillManagementService;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet(name = "confirmBill", value = "/confirmBill")
public class ConfirmBillController extends HttpServlet {
    @Inject
    IBillManagementService iBillManagementService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
        if(id != null) {

            int idInt = Integer.parseInt(id);
            iBillManagementService.confirmBill(id);
            request.setAttribute("message", "Xác nhận thành công đơn hàng: " + id);
            Log log = new Log(Log.ALER,ip,"Xác nhận đơn hàng",cus.getIdUser(),"Xác nhận đơn hàng: " + id,1);
            log.insert();
            response.sendRedirect(request.getContextPath() + "/admin-table-order-confirm");


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
