package vn.edu.hcmuaf.fit.controller.web.loginWithGoogle;



import vn.edu.hcmuaf.fit.model.GoogleModel;
import vn.edu.hcmuaf.fit.utils.GoogleUtil;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login-google")
public class LoginGoogleController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public LoginGoogleController() {
    super();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String code = request.getParameter("code");
    if (code == null || code.isEmpty()) {
      RequestDispatcher dis = request.getRequestDispatcher("/views/login.jsp");
      dis.forward(request, response);
    } else {
        String accessToken = GoogleUtil.getToken(code);
        GoogleModel googlePojo = GoogleUtil.getUserInfo(accessToken);
        CustomerDAO dao = new CustomerDAO();
        String email = googlePojo.getEmail();
        String fName = googlePojo.getFamily_name();
        String lName = googlePojo.getGiven_name();
        CustomerModel account = dao.checkAccountExist(email);
        if (account == null) {
            dao.signup(email, "", fName, lName, "", "");
            dao.updateTypeLogin(email);
        }
            CustomerModel customer = dao.findByUsername(email);
            SessionUtil.getInstance().putValue(request, "USERMODEL", customer);
            if (customer.getRole().equalsIgnoreCase("user")) {

                response.sendRedirect(request.getContextPath() + "/home");
//                        req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
            } else if (customer.getRole().equalsIgnoreCase("admin")) {
                response.sendRedirect(request.getContextPath() + "/admin-root-home");
            } else if (customer.getRole().equalsIgnoreCase("mod")) {
                response.sendRedirect(request.getContextPath() + "/admin-home");
            }
        }


  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
