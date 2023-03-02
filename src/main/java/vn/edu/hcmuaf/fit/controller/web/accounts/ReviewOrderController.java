package vn.edu.hcmuaf.fit.controller.web.accounts;

import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.MessageParameterUntil;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "reviewOrder", value = "/order/reviewOrder")
public class ReviewOrderController extends HttpServlet {
    IBillDAO iBillDAO = new BillDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        String orderSuccess = request.getParameter("orderSuccess");
        request.setAttribute("listBillDeliverByIdOrder", iBillDAO.findBillDeliverByIdOrder(cus.getIdUser()));
        request.setAttribute("listBillWarByIdOrder", iBillDAO.findBillWarByIdOrder(cus.getIdUser()));
        request.setAttribute("listBillDelivByIdOrder", iBillDAO.findBillDelivByIdOrder(cus.getIdUser()));
        request.setAttribute("listBillRateByIdOrder", iBillDAO.findBillRateByIdOrder(cus.getIdUser()));
        request.setAttribute("listBillByIdOrder", iBillDAO.findBillByIdOrder(cus.getIdUser()));
        request.setAttribute("orderSuccess", orderSuccess);
        request.getRequestDispatcher("/views/web/reviewOrders.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
