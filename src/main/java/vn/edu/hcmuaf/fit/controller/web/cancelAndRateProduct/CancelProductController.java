package vn.edu.hcmuaf.fit.controller.web.cancelAndRateProduct;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.MessageParameterUntil;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet(name = "cancelOrder", value = "/cancelOrder")
public class CancelProductController extends HttpServlet {
    IBillDAO iBillDAO = new BillDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        int result = iBillDAO.cancelOrder(idInt);
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
        if(result > 0) {
            request.setAttribute("listBillDeliverByIdOrder", iBillDAO.findBillDeliverByIdOrder(cus.getIdUser()));
            request.setAttribute("listBillWarByIdOrder", iBillDAO.findBillWarByIdOrder(cus.getIdUser()));
            request.setAttribute("listBillDelivByIdOrder", iBillDAO.findBillDelivByIdOrder(cus.getIdUser()));
            request.setAttribute("listBillRateByIdOrder", iBillDAO.findBillRateByIdOrder(cus.getIdUser()));
            request.setAttribute("listBillByIdOrder", iBillDAO.findBillByIdOrder(cus.getIdUser()));
            Log log = new Log(Log.ALER,ip,"Cancel Product", cus.getIdUser(),"Customer cancel product: "+ id,1);
            log.insert();
            new MessageParameterUntil("Hủy đơn hàng thành công", "success", "/views/web/reviewOrders.jsp", request, response).send();

        }else {
            new MessageParameterUntil("Hủy đơn hàng thất bại", "danger", "/views/web/reviewOrders.jsp", request, response).send();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
