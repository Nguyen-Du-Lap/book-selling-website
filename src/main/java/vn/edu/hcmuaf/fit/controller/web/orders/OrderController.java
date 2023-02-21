package vn.edu.hcmuaf.fit.controller.web.orders;

import vn.edu.hcmuaf.fit.dao.ICustomerDAO;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.Cart;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IOrderService;
import vn.edu.hcmuaf.fit.services.impl.OrderService;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "order", value = "/order")
public class OrderController extends HttpServlet {
    IOrderService orderService = new OrderService();
    ICustomerDAO customerDAO = new CustomerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        if(cus == null) {
            response.sendRedirect("/login?action=login");
        }else{
            String listId =  request.getParameter("list_id");

            if(listId.equals("")){
                request.setAttribute("message", "Chưa chọn sản phẩm");
                request.setAttribute("alert", "warning");
                request.getRequestDispatcher("/views/web/cart.jsp").forward(request, response);
            }else if(orderService.checkIdExistsInCart(listId, request, response)) {
                request.setAttribute("message", "Sản phẩm không tồn tại");
                request.setAttribute("alert", "warning");
                request.getRequestDispatcher("/views/web/cart.jsp").forward(request, response);
            }
            else{
                CustomerModel customerModel = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");

                Cart cartOrder = orderService.cartOrder(listId, request);

                request.setAttribute("cartOrder", cartOrder);
                request.setAttribute("customer", customerDAO.findById(customerModel.getIdUser()));
                request.setAttribute("transportFee", 30000);
                request.setAttribute("totalPrice", cartOrder.getTotalPrice());
                request.getRequestDispatcher("/views/web/order.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
