package vn.edu.hcmuaf.fit.controller.adminRoot.managementSale;

import vn.edu.hcmuaf.fit.dao.impl.VoucherDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "admin-root-table-sales", value = "/admin-root-table-sales")
public class ManagementSaleController extends HttpServlet {
    VoucherDAO voucherDAO = new VoucherDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Danh Sách Khuyến Mãi");
        request.setAttribute("listVoucher", voucherDAO.findAllVoucher());
        System.out.println(voucherDAO.findAllVoucher());
        request.getRequestDispatcher("views/admin_root/management-sales.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
