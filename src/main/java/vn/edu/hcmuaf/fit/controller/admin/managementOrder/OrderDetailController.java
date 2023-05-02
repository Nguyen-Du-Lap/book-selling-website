package vn.edu.hcmuaf.fit.controller.admin.managementOrder;

import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "admin-order-detail", value = "/admin-order-detail")
public class OrderDetailController extends HttpServlet {
    CustomerDAO customerDAO = new CustomerDAO();
    BillDAO billDAO = new BillDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);

        int idCus = billDAO.find1BillById(idInt).getIdUser();
        request.setAttribute("CUSTOMER", customerDAO.findById(idCus));
        request.setAttribute("BILLDETAIL", billDAO.find1BillById(idInt));
        request.getRequestDispatcher("/views/admin/confirm-order-detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
