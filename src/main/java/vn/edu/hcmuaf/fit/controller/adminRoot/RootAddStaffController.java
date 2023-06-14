package vn.edu.hcmuaf.fit.controller.adminRoot;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.MD5Utils;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet(name = "admin-root-add-staff", value = "/admin-root-add-staff")
public class RootAddStaffController extends HttpServlet {
    CustomerDAO dao = new CustomerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");
        if( message != null && alert != null) {
            request.setAttribute("message", message);
            request.setAttribute("alert", alert);
        }
        request.getRequestDispatcher("/views/admin_root/form-add-staff.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
        String lastName = request.getParameter("nameLast");
        String firstName = request.getParameter("nameFirst");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String numberPhone = request.getParameter("numberPhone");
        String addess = request.getParameter("addess");

        if(lastName == null||firstName == null||email == null||password == null||numberPhone == null||addess == null|| lastName.isEmpty() ||firstName.isEmpty() ||email.isEmpty() ||password.isEmpty() ||numberPhone.isEmpty() || addess.isEmpty()) {
            response.sendRedirect("/admin-root-add-staff?message=Them that bai&alert=danger");
        } else {
            if(dao.findByUsername(email) != null) {
                response.sendRedirect("/admin-root-add-staff?message=Email đã tồn tại bai&alert=danger");
            } else {
                String pass = MD5Utils.encrypt(password);
                Log log = new Log(Log.INFO,ip,"Quản lý nhân viên",cus.getIdUser(),"Thêm nhân viên",1);
                log.insert();
                dao.signupMod(email,pass,firstName,lastName,numberPhone,addess);
                response.sendRedirect("/admin-root-add-staff?message=Them thanh cong&alert=success");
            }
        }

    }
}
