package vn.edu.hcmuaf.fit.controller.admin.managementOrder;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.db.MessageProperties;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IBillManagementService;
import vn.edu.hcmuaf.fit.utils.MessageParameterUntil;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet(name = "admin-register-order", value = "/admin-register-order")
public class RegisterOrderController extends HttpServlet {
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
            Log log = new Log(Log.ALER,ip,"Đăng kí đơn hàng",cus.getIdUser(),"Đăng kí đơn hàng vận chuyển: " + id,1);
            log.insert();
            request.setAttribute("message", "Đăng kí đơn hàng thành công: " + id);
            request.setAttribute("alert", "success");
            response.sendRedirect(request.getContextPath() + "/admin-order-detail?id="+id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
