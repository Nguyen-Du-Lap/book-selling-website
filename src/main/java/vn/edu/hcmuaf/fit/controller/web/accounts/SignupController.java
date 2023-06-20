package vn.edu.hcmuaf.fit.controller.web.accounts;

import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.db.MessageProperties;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.EmailUtil;
import vn.edu.hcmuaf.fit.utils.MD5Utils;
import vn.edu.hcmuaf.fit.utils.MessageParameterUntil;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "signup", value = "/signup")
public class SignupController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/web/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String re_pass = request.getParameter("password2");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phone = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        //String idUser = request.getParameter("id_user");
        if (!email.equals("") && !pass.equals("") && !re_pass.equals("") && !fname.equals("") && !lname.equals("")) {
            if (!pass.equals(re_pass)) {
                response.sendRedirect(request.getContextPath()+"/login");
            } else {
                CustomerDAO customerDAO = new CustomerDAO();
                CustomerModel account = customerDAO.checkAccountExist(email);
                if (account == null) {
                    EmailUtil sm = new EmailUtil();
                    String code = sm.getRandom();
                    CustomerModel user = new CustomerModel(email, pass, fname, lname, phone, address, code, System.currentTimeMillis() / 1000 / 60);
                    sm.sendEmail(user);
                    HttpSession session = request.getSession();
                    session.setAttribute("registerUser", user);

                    new MessageParameterUntil("Chúng tôi đã gửi mã xác minh đến email của bạn", "success", "/views/web/confirmRegister.jsp", request, response).send();
                } else {
                    if (customerDAO.getTypeLogin(account.getEmail()) == 2) {
                        new MessageParameterUntil("Tài khoản này của bạn đã được đăng nhập bằng tài khoản google", "danger", "/views/web/confirmRegister.jsp", request, response).send();
                    } else {
                        new MessageParameterUntil("Email đã tồn tại", "danger", "/views/web/signup.jsp", request, response).send();
                    }

                }
            }
        }else {
            new MessageParameterUntil("Vui lòng nhập thông tin đầy đủ", "danger", "/views/web/signup.jsp", request, response).send();

            }

        }
    }
