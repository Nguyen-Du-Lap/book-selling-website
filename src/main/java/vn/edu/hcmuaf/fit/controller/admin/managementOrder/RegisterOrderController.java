package vn.edu.hcmuaf.fit.controller.admin.managementOrder;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.impl.CartDao;
import vn.edu.hcmuaf.fit.dao.impl.InformationDeliverDao;
import vn.edu.hcmuaf.fit.db.MessageProperties;
import vn.edu.hcmuaf.fit.model.CartModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.model.InformationDeliverModel;
import vn.edu.hcmuaf.fit.services.IBillManagementService;
import vn.edu.hcmuaf.fit.utils.FeeGHNUtils;
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
        CartDao dao = new CartDao();
        String idCus = request.getParameter("variable");

        if(id != null) {
            int idInt = Integer.parseInt(id);
            int idCusInt = Integer.parseInt(idCus);
            InformationDeliverDao daoInFo = new InformationDeliverDao();
            InformationDeliverModel info = daoInFo.getById(idInt);
            daoInFo.updateToken(idInt,FeeGHNUtils.registerShip(info.getX()+"", info.getY()+"", info.getZ()+"", info.getW()+"",1463,21808,info.getDistrictTo(), info.getWarTo()));
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
