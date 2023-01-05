package vn.edu.hcmuaf.fit.controller.web.accounts;

import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.db.MessageProperties;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.model.EmailModel;
import vn.edu.hcmuaf.fit.utils.EmailUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "forgotPassword", value = "/forgotPassword")
public class ForgotPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/web/forgotPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try {
            String emailAddress = request.getParameter("email");
            //String fname = request.getParameter("fname");
            //String lname = request.getParameter("lname");
            if (!emailAddress.equals("")) {
                CustomerDAO customerDAO = new CustomerDAO();
                CustomerModel account = customerDAO.checkAccountExist(emailAddress);
                if (account == null) {
                    request.setAttribute("message", MessageProperties.getNot_found_email());
                    request.setAttribute("alert", "danger");
                    request.getRequestDispatcher("/views/web/forgotPassword.jsp").forward(request, response);
                } else {
                    EmailModel email = new EmailModel();
                    email.setFrom("anminh868@gmail.com");
                    email.setFromPassword("password");
                    email.setTo(emailAddress);
                    email.setSubject("Forgot Password Function");
                    StringBuilder sb = new StringBuilder();
                    sb.append("Dear ").append("<br>");
                    sb.append("You are used the forgot password function. <br>");
                    sb.append("Your new password is <b>").append(account.getPassword()).append("</b>");
                    sb.append("Regards<br>");
                    sb.append("Administrator");

                    email.setContent(sb.toString());
                    EmailUtil.send(email);

                    request.setAttribute("message", MessageProperties.getRe_login());
                    request.setAttribute("alert", "success");
                    request.getRequestDispatcher("/views/login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("message", MessageProperties.getMissing_mail());
                request.setAttribute("alert", "danger");
                request.getRequestDispatcher("/views/web/forgotPassword.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
