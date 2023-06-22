package vn.edu.hcmuaf.fit.controller.adminRoot;

import vn.edu.hcmuaf.fit.dao.impl.CartDao;
import vn.edu.hcmuaf.fit.dao.impl.StatisticalDao;
import vn.edu.hcmuaf.fit.filter.MaintenanceFilter;
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

@WebServlet(name = "/admin-root-home", value = "/admin-root-home")
public class HomeRootController extends HttpServlet {
    @Inject
    ICustomerService iCustomerService;
    @Inject
    IProductService iProductService;
    @Inject
    IBillService iBillService;
    CartDao cartDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // title dung de active aside
        cartDao = new CartDao();
        req.setAttribute("title", "Bảng điều khiển");
        req.setAttribute("thongKe", new StatisticalDao().thuNhapTrong6Thang());
        req.setAttribute("totalCustomer", iCustomerService.totalCustomer());
        req.setAttribute("totalProduct", iProductService.totalProduct());
        req.setAttribute("totalBill", cartDao.getAllCart().size());
        req.setAttribute("outOfStock", iProductService.outOfStock());
        req.setAttribute("shippingInfo", cartDao.getAllCart());
        req.setAttribute("newCustomer", iCustomerService.newCustomer());
        // kiểm tra xem hệ thống có đạng bảo trì ko
        req.setAttribute("maintenance", MaintenanceFilter.maintenanceMode);
        req.getRequestDispatcher("views/admin_root/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}
