package vn.edu.hcmuaf.fit.controller.adminRoot.managementSale;

import vn.edu.hcmuaf.fit.dao.impl.VoucherDAO;
import vn.edu.hcmuaf.fit.utils.MessageParameterUntil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "admin-root-add-voucher", value = "/admin-root-add-voucher")
public class AddSaleController extends HttpServlet {
    private VoucherDAO voucherDAO = new VoucherDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/admin_root/form-add-voucher.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        String quantity = request.getParameter("quantity");
        String percent_discount = request.getParameter("percent_discount");
        String diktat = request.getParameter("diktat");
        String price_minimum = request.getParameter("price_minimum");

        if(!name.equals("") && !quantity.equals("") && !percent_discount.equals("") && !diktat.equals("") && !price_minimum.equals("")) {
            int qualityInt = Integer.parseInt(quantity);
            int percent_discountInt = Integer.parseInt(percent_discount);
            int price_minimumInt = Integer.parseInt(price_minimum);
            voucherDAO.addVoucher(name, qualityInt, percent_discountInt, diktat, price_minimumInt);
        }

        new MessageParameterUntil("Thêm thành công", "success", "views/admin_root/form-add-voucher.jsp", request, response).send();
    }
}
