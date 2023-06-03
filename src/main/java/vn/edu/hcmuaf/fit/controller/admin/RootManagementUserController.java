package vn.edu.hcmuaf.fit.controller.admin;

import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.ICustomerService;
import vn.edu.hcmuaf.fit.services.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "admin-management-user", value = "/admin-root-management-user")
public class RootManagementUserController extends HttpServlet {
    ICustomerService iCustomerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // title dung de active aside
        CustomerDAO dao = new CustomerDAO();
        List<CustomerModel> users = dao.getAllUserAdmin();
        System.out.println(users.size());
        request.setAttribute("title", "Danh Sách Nhân Viên");
        request.setAttribute("listStaff", users);
        request.getRequestDispatcher("/views/admin_root/management-user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}