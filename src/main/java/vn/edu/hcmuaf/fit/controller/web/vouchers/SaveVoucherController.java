package vn.edu.hcmuaf.fit.controller.web.vouchers;

import vn.edu.hcmuaf.fit.dao.IVoucherDAO;
import vn.edu.hcmuaf.fit.dao.impl.VoucherDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "saveVoucher", value = "/saveVoucher")
public class SaveVoucherController extends HttpServlet {
    IVoucherDAO iVoucherDAO = new VoucherDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        if(id!= null) {
            int idInt = Integer.parseInt(id);
            iVoucherDAO.saveVoucherCus(idInt, cus.getIdUser());
            iVoucherDAO.updateVoucher(idInt);
        }
        response.sendRedirect("/voucher");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
