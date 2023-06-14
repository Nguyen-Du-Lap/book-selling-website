package vn.edu.hcmuaf.fit.controller.admin.managementOrder;

import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.dao.impl.CartDao;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.CartModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "admin-order-detail", value = "/admin-order-detail")
public class OrderDetailController extends HttpServlet {
    CartDao cartDao = new CartDao();
    BillDAO billDAO = new BillDAO();
    CustomerDAO customerDAO = new CustomerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        CartModel cartModel = cartDao.getCartById(idInt);
        System.out.println(billDAO.find1BillByIdCart(cartModel.getId()).toString());
        request.setAttribute("CUSTOMER", customerDAO.findById(cartModel.getIdUser())) ;
        request.setAttribute("cart", listDonHang(idInt));
        request.setAttribute("LISTBILL",  cartDao.getAllDetailCart(cartModel.getIdUser(),idInt));
        request.getRequestDispatcher("/views/admin/confirm-order-detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public CartModel listDonHang( int id) {
        CartDao cartDao = new CartDao();
        CartModel listModel = cartDao.getCartById(id);
        listModel.setBills(new BillDAO().findAllBillByIdCart( listModel.getId()));


        return listModel;
    }
}
