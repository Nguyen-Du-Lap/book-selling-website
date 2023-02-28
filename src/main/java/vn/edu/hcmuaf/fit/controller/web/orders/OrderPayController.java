package vn.edu.hcmuaf.fit.controller.web.orders;

import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.model.Cart;
import vn.edu.hcmuaf.fit.model.CartItem;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IBillService;
import vn.edu.hcmuaf.fit.services.impl.BillService;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "order/pay", value = "/order/pay")
public class OrderPayController extends HttpServlet {
    IBillService billService = new BillService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String ward = request.getParameter("ward");
        String pack = request.getParameter("pack");
        String pay = request.getParameter("pay");
        String info = request.getParameter("note");
        int packInt = Integer.parseInt(pack);
        int payInt = Integer.parseInt(pay);
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");

        Cart cart = (Cart) request.getSession().getAttribute("cartOrder");

        for (Map.Entry<Integer, CartItem> entry : cart.getMap().entrySet()) {
            Integer id = entry.getKey();
            CartItem item = entry.getValue();
            billService.addBill(cus.getIdUser(), item.getProduct().getIdBook(),
                    address, city, district, ward, packInt, payInt,
                    item.getQuantity(), cart.getTotalPriceShipVoucher(), info, phone, request, response);
        }
    }
}
