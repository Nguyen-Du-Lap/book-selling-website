package vn.edu.hcmuaf.fit.controller.loginGG.Servlet;



import vn.edu.hcmuaf.fit.controller.loginGG.common.GooglePojo;
import vn.edu.hcmuaf.fit.controller.loginGG.common.GoogleUtils;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public LoginGoogleServlet() {
    super();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String code = request.getParameter("code");
    if (code == null || code.isEmpty()) {
      RequestDispatcher dis = request.getRequestDispatcher("/views/login.jsp");
      dis.forward(request, response);
    } else {
      String accessToken = GoogleUtils.getToken(code);
     GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
      CustomerDAO dao = new CustomerDAO();
      String email = googlePojo.getEmail();
      String fName = googlePojo.getFamily_name();
      String lName = googlePojo.getGiven_name();
      CustomerModel account = dao.checkAccountExist(email);
      if(account == null) {
        dao.signup(email,"",fName,lName,"","");
              }

      RequestDispatcher dis = request.getRequestDispatcher("/views/thongTin.jsp");
      dis.forward(request, response);
    }
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
