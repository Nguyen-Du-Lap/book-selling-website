package vn.edu.hcmuaf.fit.controller.web.orders;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.impl.CartDao;
import vn.edu.hcmuaf.fit.dao.impl.InformationDeliverDao;
import vn.edu.hcmuaf.fit.model.CartModel;
import vn.edu.hcmuaf.fit.model.CartItem;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.model.InformationDeliverModel;
import vn.edu.hcmuaf.fit.services.IBillService;
import vn.edu.hcmuaf.fit.services.impl.BillService;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "order/pay", value = "/order/pay")
public class OrderPayController extends HttpServlet {
    IBillService billService = new BillService();
    CartDao dao = new CartDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
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

        CartModel cart = (CartModel) request.getSession().getAttribute("cartOrder");
        cart.setIdUser(cus.getIdUser());
        List<Integer> listIdRemove = new ArrayList<>();
        Set<Integer> keySet = cart.getMap().keySet();
        for (Integer key : keySet) {
            CartItem item = cart.getMap().get(key);
            billService.addBill(cus.getIdUser(), item.getProduct().getIdBook(),
                    address, city, district, ward, packInt, payInt,
                    item.getQuantity(), cart.getTotalPriceShipVoucher(), info, phone, dao.setID(),request, response);
            Log log = new Log(Log.INFO,ip,"OrderPay", cus.getIdUser(), "The customer makes the payment: "+ item.getProduct().getIdBook(),1);
            log.insert();
            listIdRemove.add(item.getProduct().getIdBook());
        }
        HttpSession httpSession = request.getSession();
        InformationDeliverModel informationDeliverModel = (InformationDeliverModel) httpSession.getAttribute("deliver");
        informationDeliverModel.setIdOrder(dao.setID());
        InformationDeliverDao informationDeliverDao = new InformationDeliverDao();
        informationDeliverDao.insertInfomationDeliver(informationDeliverModel);
        dao.insertCart( cart.getIdUser(),cart.getTimeShip(),cart.getShip(), cart.getTotalPriceShipVoucher(),"1" );
        billService.removeProductInCart(listIdRemove, request);
        response.sendRedirect(request.getContextPath()+"/order/reviewOrder?orderSuccess=1");
    }


}
