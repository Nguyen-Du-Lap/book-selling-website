package vn.edu.hcmuaf.fit.controller.web.orders;

import vn.edu.hcmuaf.fit.model.Cart;
import vn.edu.hcmuaf.fit.model.CartItem;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IBillService;
import vn.edu.hcmuaf.fit.services.impl.BillService;
import vn.edu.hcmuaf.fit.utils.FeeGHNUtils;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "order/fee", value = "/orderFee")
public class OrderFeeController extends HttpServlet {
    IBillService billService = new BillService();

    public int feeDeliver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameDistrict = request.getParameter("exits");
        int feeDiver = FeeGHNUtils.getFeeGHN(nameDistrict);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cartOrder");
        cart.setShip(feeDiver);
        return feeDiver;

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(feeDeliver(request,response));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cartOrder");
        cart.setShip(feeDeliver(request,response));
        PrintWriter out = response.getWriter();
        out.println(cart.getTotalPriceShip());
    }
}
