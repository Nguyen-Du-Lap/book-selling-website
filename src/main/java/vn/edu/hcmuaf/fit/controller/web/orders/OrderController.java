package vn.edu.hcmuaf.fit.controller.web.orders;

import vn.edu.hcmuaf.fit.dao.ICustomerDAO;
import vn.edu.hcmuaf.fit.dao.IDiscountCustomerDAO;
import vn.edu.hcmuaf.fit.dao.IVoucherDAO;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.dao.impl.DiscountCustomerDAO;
import vn.edu.hcmuaf.fit.dao.impl.VoucherDAO;
import vn.edu.hcmuaf.fit.model.CartModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IOrderService;
import vn.edu.hcmuaf.fit.services.impl.OrderService;
import vn.edu.hcmuaf.fit.utils.MessageParameterUntil;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "order", value = "/order")
public class OrderController extends HttpServlet {
    IOrderService orderService = new OrderService();
    ICustomerDAO customerDAO = new CustomerDAO();
    IDiscountCustomerDAO discountCustomerDAO = new DiscountCustomerDAO();

    IVoucherDAO voucherDAO = new VoucherDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        if(cus == null) {
            response.sendRedirect(request.getContextPath()+"/login?action=login");
        }else{
            String idVoucher = request.getParameter("idVoucher");
            if(idVoucher.equals("") || idVoucher == null) {
                new MessageParameterUntil("Mã giảm giá không tồn tại", "warning", "/views/web/cart.jsp", request, response).send();
            }else {
                int idVoucherInt = Integer.parseInt(idVoucher);
                if(idVoucherInt == 1000000) {
                    setOrderNotVoucher(cus, request, response);
                }else if(!discountCustomerDAO.checkIdVoucherInCus(idVoucherInt, cus.getIdUser())) {
                    new MessageParameterUntil("Mã giảm giá không tồn tại", "warning", "/views/web/cart.jsp", request, response).send();
                } else {
                    setOrderVoucher(idVoucherInt ,cus, request, response);
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void setOrderNotVoucher(CustomerModel cus, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customer", customerDAO.findById(cus.getIdUser()));
        request.getRequestDispatcher("/views/web/order.jsp").forward(request, response);
    }

    public void setOrderVoucher(int idVoucher, CustomerModel cus, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int priceDiscount = voucherDAO.getPriceVoucher(idVoucher);
        CartModel cartOrder = (CartModel) request.getSession().getAttribute("cartOrder");
        cartOrder.setVoucher(priceDiscount);
        cartOrder.setShip(30000);
        request.getSession().setAttribute("cartOrder", cartOrder);
        request.setAttribute("listDiscount", discountCustomerDAO.findDisByIdVou(cus.getIdUser(), idVoucher));
        request.setAttribute("customer", customerDAO.findById(cus.getIdUser()));
        request.getRequestDispatcher("/views/web/order.jsp").forward(request, response);
    }

}
