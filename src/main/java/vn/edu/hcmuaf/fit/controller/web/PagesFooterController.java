package vn.edu.hcmuaf.fit.controller.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "pages", value = "/pages")
public class PagesFooterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page !=null) {
            if(page.equalsIgnoreCase("paymentMethod")) {
                request.getRequestDispatcher("/views/web/paymentMethod.jsp").forward(request, response);
            }
            if(page.equalsIgnoreCase("privacyPolicy")) {
                request.getRequestDispatcher("/views/web/privacyPolicy.jsp").forward(request, response);
            }
            if(page.equalsIgnoreCase("returnPolicy")) {
                request.getRequestDispatcher("/views/web/returnPolicy.jsp").forward(request, response);
            }
            if(page.equalsIgnoreCase("termsOfUse")) {
                request.getRequestDispatcher("/views/web/termsOfUse.jsp").forward(request, response);
            }
            if(page.equalsIgnoreCase("transport")) {
                request.getRequestDispatcher("/views/web/transport.jsp").forward(request, response);
            }
            if(page.equalsIgnoreCase("contact")) {
                request.getRequestDispatcher("/views/web/contact.jsp").forward(request, response);
            }
            if(page.equalsIgnoreCase("about")) {
                request.getRequestDispatcher("/views/web/about.jsp").forward(request, response);
            }
            if(page.equalsIgnoreCase("guideOrder")) {
                request.getRequestDispatcher("/views/web/guideOrder.jsp").forward(request, response);
            }
        }else {
            response.sendRedirect(request.getContextPath()+"/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
