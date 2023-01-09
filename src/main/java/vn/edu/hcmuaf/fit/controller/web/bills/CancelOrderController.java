package vn.edu.hcmuaf.fit.controller.web.bills;

import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "cancelOrder", value = "/cancelOrder")
public class CancelOrderController extends HttpServlet {
    IBillDAO iBillDAO = new BillDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id != null) {
            int idInt = Integer.parseInt(id);
            int updateBill = iBillDAO.cancelOrder(idInt);
            if(updateBill >=1) {
                request.setAttribute("message", "Da huy don");
                request.setAttribute("alert", "success");
            }else {
                request.setAttribute("message", "Huy don that bai");
                request.setAttribute("alert", "danger");
            }
            CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
            request.setAttribute("listBillDeliverByIdOrder", iBillDAO.findBillDeliverByIdOrder(cus.getIdUser()));
            request.setAttribute("listBillWarByIdOrder", iBillDAO.findBillWarByIdOrder(cus.getIdUser()));
            request.getRequestDispatcher("/views/web/reviewOrders.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
