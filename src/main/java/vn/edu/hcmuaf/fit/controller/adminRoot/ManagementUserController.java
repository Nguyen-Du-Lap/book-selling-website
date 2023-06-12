package vn.edu.hcmuaf.fit.controller.adminRoot;

import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "admin-management-user", value = "/admin-root-management-user")

public class ManagementUserController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // title dung de active aside
        CustomerDAO dao = new CustomerDAO();
        List<CustomerModel> users = dao.getAllUserAdmin();
        request.setAttribute("title", "Danh Sách Nhân Viên");
        request.setAttribute("listStaff", users);
        request.getRequestDispatcher("/views/admin_root/management-user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}