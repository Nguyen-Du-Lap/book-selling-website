package vn.edu.hcmuaf.fit.controller.web.accounts;

import org.apache.commons.beanutils.BeanUtils;
import vn.edu.hcmuaf.fit.dao.ICustomerDAO;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.db.MessageProperties;
import vn.edu.hcmuaf.fit.model.ChangePasswordModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.MD5Utils;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "changePassword", value = "/changePassword")
public class ChangePasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = (String) SessionUtil.getInstance().getValue(request, "USERMODEL");
        if (account == null) {
            request.setAttribute("message", MessageProperties.getRe_login());
            request.setAttribute("alert", "danger");
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
            return;
        }
        request.setAttribute("account", account);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
            String ollPass = request.getParameter("oldPass");
            String newPass = request.getParameter("newPass");
            String confirm = request.getParameter("confirmPass");
            ICustomerDAO dao = new CustomerDAO();
            CustomerModel account  = dao.findByUsernameAndPasswordAndStatus(cus.getEmail(), MD5Utils.encrypt(ollPass), cus.getStatus());
            if(account != null ) {
                if(!newPass.equals(confirm)) {
                    request.setAttribute("message", "new passwords and confirmation passwords don't match");
                    request.setAttribute("alert", "danger");
                    request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
                } else {
                    dao.changePassWord(cus.getEmail(), MD5Utils.encrypt(newPass));
                    request.setAttribute("message", "Successful");
                    request.setAttribute("alert", "success");
                    request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
