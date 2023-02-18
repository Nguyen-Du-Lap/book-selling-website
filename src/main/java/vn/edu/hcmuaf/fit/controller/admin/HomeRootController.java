package vn.edu.hcmuaf.fit.controller.admin;

import vn.edu.hcmuaf.fit.services.IBillService;
import vn.edu.hcmuaf.fit.services.ICustomerService;
import vn.edu.hcmuaf.fit.services.IProductService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/admin-root-home", value = "/admin-root-home")
public class HomeRootController extends HttpServlet {
    @Inject
    ICustomerService iCustomerService;
    @Inject
    IProductService iProductService;
    @Inject
    IBillService iBillService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // title dung de active aside
        req.setAttribute("title", "Bảng điều khiển");
        req.setAttribute("totalCustomer", iCustomerService.totalCustomer());
        req.setAttribute("totalProduct", iProductService.totalProduct());
        req.setAttribute("totalBill", iBillService.totalBill());
        req.setAttribute("outOfStock", iProductService.outOfStock());
        req.setAttribute("shippingInfo", iBillService.shippingInfo());
        req.setAttribute("newCustomer", iCustomerService.newCustomer());
        req.getRequestDispatcher("views/admin_root/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
