package vn.edu.hcmuaf.fit.controller.web.loginWithFacebook;

import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.StringTokenizer;

@WebServlet(name = "loginFacebookController", value = "/loginFacebookController")
public class LoginFacebookController extends HttpServlet {
    CustomerDAO customerDAO = new CustomerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");

        if(action.equals("Face")){
            String name=request.getParameter("name");
            String email=request.getParameter("email");

            CustomerModel account = customerDAO.checkAccountExist(email);

            if (account == null) {
                StringTokenizer stName = new StringTokenizer(name);
                String fName = stName.nextToken();
                String lName = stName.nextToken();
                customerDAO.signup(email, "", fName, lName, "", "");
            }
            CustomerModel customer = customerDAO.findByUsername(email);
            SessionUtil.getInstance().putValue(request, "USERMODEL", customer);
            if (customer.getRole().equalsIgnoreCase("user")) {
                response.sendRedirect(request.getContextPath() + "/home");
            } else if (customer.getRole().equalsIgnoreCase("admin")) {
                response.sendRedirect(request.getContextPath() + "/admin-root-management-user");
            } else if (customer.getRole().equalsIgnoreCase("mod")) {
                response.sendRedirect(request.getContextPath() + "/admin-home");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
