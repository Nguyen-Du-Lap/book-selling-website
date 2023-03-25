package vn.edu.hcmuaf.fit.controller.web.accounts;

import vn.edu.hcmuaf.fit.dao.ICustomerDAO;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.MD5Utils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "changePasswordForgot", value = "/changePasswordForgot")
public class ChangePasswordForgotController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            CustomerModel cus = (CustomerModel) session.getAttribute("UserForgotPass");
            String newPass = request.getParameter("newPass");
            String confirm = request.getParameter("confirmPass");
            ICustomerDAO dao = new CustomerDAO();
            CustomerModel account  = dao.findByUsername(cus.getEmail());
                if(!newPass.equals(confirm)) {
                    request.setAttribute("message", "new passwords and confirmation passwords don't match");
                    request.setAttribute("alert", "danger");
                    request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
                } else {
                    dao.changePassWord(cus.getEmail(), MD5Utils.encrypt(newPass));
                    session.removeAttribute("UserForgotPass");
                    request.setAttribute("message", "Successful");
                    request.setAttribute("alert", "success");
                    request.getRequestDispatcher("/views/login.jsp").forward(request, response);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
