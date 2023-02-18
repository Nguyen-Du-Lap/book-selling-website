package vn.edu.hcmuaf.fit.controller.admin;

import vn.edu.hcmuaf.fit.services.IBillService;
import vn.edu.hcmuaf.fit.services.ICustomerService;
import vn.edu.hcmuaf.fit.services.IProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/admin-home"})
public class HomeController extends HttpServlet {
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
        req.getRequestDispatcher("views/admin/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
