package vn.edu.hcmuaf.fit.controller.admin.managementCustomer;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.ICustomerService;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet(name = "update-customer", value = "/update-customer")
public class UpdateCustomerController extends HttpServlet {
    @Inject
    ICustomerService iCustomerService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");
        if(message != null && alert!= null) {
            request.setAttribute("message", message);
            request.setAttribute("alert", alert);
        }
        request.getRequestDispatcher("views/admin/table-data-customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        try {
            int i = iCustomerService.update(idUser, firstName, lastName, phone, address);
            if(i >= 1) {
                Log log = new Log(Log.WARNING,ip,"Chỉnh sửa thông tin người dùng",cus.getIdUser(),"Tài khoản được chỉnh sửa: " + idUser,1);
                log.insert();
                response.sendRedirect("/admin-table-customer?message=Upload success&alert=success");
            }else {
                response.sendRedirect("/admin-table-customer?message=Upload error&alert=error");
            }
        } catch (Exception e) {
            request.getRequestDispatcher("views/admin/table-data-customer.jsp").forward(request, response);
        }
    }
}
