package vn.edu.hcmuaf.fit.controller.web.accounts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "account", value = "/account")

public class AccountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action != null) {
            if(action.equalsIgnoreCase("account")) {
                request.getRequestDispatcher("/views/web/account.jsp").forward(request, response);
            }else if(action.equalsIgnoreCase("changePassword")) {
                request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
            }else if(action.equalsIgnoreCase("reviewOrders")) {
                request.getRequestDispatcher("/views/web/reviewOrders.jsp").forward(request, response);
            }
        }else {
            request.getRequestDispatcher("/views/web/account.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
