package vn.edu.hcmuaf.fit.controller.web.accounts;

import org.apache.commons.beanutils.BeanUtils;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.db.MessageProperties;
import vn.edu.hcmuaf.fit.model.ChangePasswordModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "changePassword", value = "/changePassword")
public class ChangePasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String account = (String) SessionUtil.getInstance().getValue(request, "USERMODEL");
//        if (account == null) {
//            request.setAttribute("message", MessageProperties.getRe_login());
//            request.setAttribute("alert", "danger");
//            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
//            return;
//        }
//        request.setAttribute("account", account);
        request.getRequestDispatcher("views/web/changePassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String confirmpass = request.getParameter("confirmpass");
        try {
            String account = (String) SessionUtil.getInstance().getValue(request, "USERMODEL");

            ChangePasswordModel changePassword = new ChangePasswordModel();
            BeanUtils.populate(changePassword, request.getParameterMap());
            request.setAttribute("account", account);
            if (!oldPass.equals("") && !newPass.equals("") && !confirmpass.equals("")) {
                if (!changePassword.getConfirmPass().equals(changePassword.getNewPass())) {
                    request.setAttribute("message", MessageProperties.getNot_login());
                    request.setAttribute("alert", "danger");
                    request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
                } else {
                    CustomerDAO user = new CustomerDAO();
                    user.changePassword(changePassword.getEmail(), changePassword.getOldPass(), changePassword.getNewPass());
                    request.setAttribute("message", MessageProperties.getMissing_mail());
                    request.setAttribute("alert", "success");
                    request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("message", MessageProperties.getMissing_data());
                request.setAttribute("alert", "danger");
                response.sendRedirect("/changePassword");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
