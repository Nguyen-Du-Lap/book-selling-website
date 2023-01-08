package vn.edu.hcmuaf.fit.controller.web.accounts;

import vn.edu.hcmuaf.fit.dao.ICustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "account", value = "/account")

public class AccountController extends HttpServlet {
    ICustomerDAO iCustomerDAO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equalsIgnoreCase("account")) {
                String email = request.getParameter("email");
                if (email != null) {
                    List<CustomerModel> list = new ArrayList<>();
                    list.add(iCustomerDAO.findByEmail(email));
                    request.setAttribute("user", list);
                }
//                CustomerModel user = new CustomerModel();
//                user.setEmail("email");
//                request.setAttribute("user", user);
                request.getRequestDispatcher("/views/web/account.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("changePassword")) {
                request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("reviewOrders")) {
                request.getRequestDispatcher("/views/web/reviewOrders.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/views/web/account.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
