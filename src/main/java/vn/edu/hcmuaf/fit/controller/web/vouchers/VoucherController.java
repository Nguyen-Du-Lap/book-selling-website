package vn.edu.hcmuaf.fit.controller.web.vouchers;

import vn.edu.hcmuaf.fit.dao.IVoucherDAO;
import vn.edu.hcmuaf.fit.dao.impl.VoucherDAO;
import vn.edu.hcmuaf.fit.db.MessageProperties;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "voucher", value = "/voucher")
public class VoucherController extends HttpServlet {
    IVoucherDAO iVoucherDAO = new VoucherDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        if(cus == null) {
            response.sendRedirect("/login?action=login");
        }else {
            request.setAttribute("listVoucher", iVoucherDAO.findAllVoucherById(cus.getIdUser()));
            request.getRequestDispatcher("/views/web/voucher.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
