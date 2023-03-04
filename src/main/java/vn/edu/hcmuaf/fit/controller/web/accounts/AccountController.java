package vn.edu.hcmuaf.fit.controller.web.accounts;

import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "account", value = "/account")


public class AccountController extends HttpServlet {
    IBillDAO iBillDAO = new BillDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        if(cus == null) {
            response.sendRedirect("/login?action=login");
        }else {

            if (action != null) {
                if (action.equalsIgnoreCase("account")) {
                    request.getRequestDispatcher("/views/web/account.jsp").forward(request, response);
                } else if (action.equalsIgnoreCase("changePassword")) {
                    request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
                } else if (action.equalsIgnoreCase("reviewOrders")) {
                    request.setAttribute("listBillDeliverByIdOrder", iBillDAO.findBillDeliverByIdOrder(cus.getIdUser()));
                    request.setAttribute("listBillWarByIdOrder", iBillDAO.findBillWarByIdOrder(cus.getIdUser()));
                    request.setAttribute("listBillDelivByIdOrder", iBillDAO.findBillDelivByIdOrder(cus.getIdUser()));
                    request.setAttribute("listBillRateByIdOrder", iBillDAO.findBillRateByIdOrder(cus.getIdUser()));
                    request.setAttribute("listBillByIdOrder", iBillDAO.findBillByIdOrder(cus.getIdUser()));
                    request.getRequestDispatcher("/views/web/reviewOrders.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/views/web/account.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
