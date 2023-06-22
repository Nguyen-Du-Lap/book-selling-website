package vn.edu.hcmuaf.fit.controller.web.orders;

import vn.edu.hcmuaf.fit.dao.impl.DiscountCustomerDAO;
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

@WebServlet(name = "orderAddVoucher", value = "/orderAddVoucher")
public class OrderAddVoucherController extends HttpServlet {
    IOrderService orderService = new OrderService();
    DiscountCustomerDAO discountCustomerDAO = new DiscountCustomerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        if(cus == null) {
            response.sendRedirect(request.getContextPath()+"/login?action=login");
        }else{
            String listId =  request.getParameter("list_id");

            if(listId.equals("")){
                new MessageParameterUntil("Chưa chọn sản phẩm", "warning", "/views/web/cart.jsp", request, response).send();
            }else if(orderService.checkIdExistsInCart(listId, request, response)) {
                new MessageParameterUntil("Sản phẩm không tồn tại", "warning", "/views/web/cart.jsp", request, response).send();
            }
            else{
                CartModel cartOrder = orderService.cartOrder(listId, request);
                cartOrder.setShip(0);
                HttpSession session = request.getSession();
                request.getSession().removeAttribute("cartOrder");
                request.getSession().setAttribute("cartOrder", cartOrder);

                request.setAttribute("listDiscount", discountCustomerDAO.listDiscountCus(cus.getIdUser(), cartOrder.getTotalPrice()));
                request.getRequestDispatcher("/views/web/orderAddVoucher.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
