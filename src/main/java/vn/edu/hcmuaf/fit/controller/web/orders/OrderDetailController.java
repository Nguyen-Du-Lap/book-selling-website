package vn.edu.hcmuaf.fit.controller.web.orders;

import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "orderDetail", value = "/orderDetail")
public class OrderDetailController extends HttpServlet {
    CustomerDAO customerDAO = new CustomerDAO();
    BillDAO billDAO = new BillDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request ,"USERMODEL");

        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);


        request.setAttribute("CUSTOMER", customerDAO.findById(cus.getIdUser()));
        request.setAttribute("BILLDETAIL", billDAO.find1BillById(idInt));
        request.getRequestDispatcher("/views/web/orderDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
