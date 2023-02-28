package vn.edu.hcmuaf.fit.controller.web.accounts;

import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.db.MessageProperties;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.EmailUtil;
import vn.edu.hcmuaf.fit.utils.MessageParameterUntil;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "confirmOTP", value = "/confirmOTP")
public class ConfirmOTP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/web/signup.jsp").forward(request, response);
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        CustomerModel user = (CustomerModel) session.getAttribute("registerUser");
        CustomerDAO dao = new CustomerDAO();
        //String idUser = request.getParameter("id_user");
        if(code.equals(user.getCode()) && (System.currentTimeMillis() / 1000/60) - user.getTime_active_code() <= 5){
            dao.signup(user.getEmail(), user.getPassword(), user.getFirstName(),user.getLastName(), user.getPhone(), user.getAddress());
            session.removeAttribute("registerUser");
            new MessageParameterUntil("Đăng kí thành công", "success", "/views/login.jsp", request, response).send();
        }else{
            new MessageParameterUntil("Mã xác minh không chính xác", "danger", "/views/web/confirmRegister.jsp", request, response).send();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);

    }
}
