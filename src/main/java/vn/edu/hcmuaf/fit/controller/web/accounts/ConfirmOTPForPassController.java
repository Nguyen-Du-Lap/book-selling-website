package vn.edu.hcmuaf.fit.controller.web.accounts;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.impl.BLockUserDAO;
import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.MD5Utils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;

@WebServlet(name = "confirmOTPForPass", value = "/confirmOTPForPass")
public class ConfirmOTPForPassController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/web/signup.jsp").forward(request, response);
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        CustomerModel user = (CustomerModel) session.getAttribute("UserForgotPass");
        int attemts =(int) session.getAttribute("attempts");
        CustomerDAO dao = new CustomerDAO();
        //String idUser = request.getParameter("id_user");
        if(code.equals(user.getCode()) && (System.currentTimeMillis() / 1000/60) - user.getTime_active_code() <= 5 && attemts > 0){
            BLockUserDAO.resetAccount(user.getEmail());

            request.getRequestDispatcher("/views/web/changePasswordForgot.jsp").forward(request,response );
        }else{
            if((System.currentTimeMillis() / 1000/60) - user.getTime_active_code() > 5 ) {
                dao.signup(user.getEmail(), MD5Utils.encrypt(user.getPassword()) , user.getFirstName(), user.getLastName(), user.getPhone(), user.getAddress());
                session.removeAttribute("UserForgotPass");
                request.setAttribute("message", "Hiệu lực của mã OPT đã hết");
                request.getRequestDispatcher("/views/login.jsp").forward(request, response);
            } else {
                if( attemts <= 0) {
                    dao.signup(user.getEmail(), MD5Utils.encrypt(user.getPassword()), user.getFirstName(), user.getLastName(), user.getPhone(), user.getAddress());
                    session.removeAttribute("UserForgotPass");
                    request.setAttribute("message", "Hiệu lực của mã OPT đã hết");
                    request.getRequestDispatcher("/views/login.jsp").forward(request, response);
                } else {
                    Log log = new Log(Log.ALER,ip,"ConfirmOTP forgot Password",user.getIdUser(),"Verification code is incorrect",1);
                    log.insert();
                    session.setAttribute("attempts", attemts -1);
                    request.setAttribute("message", "Mã xác minh không chính xác");
                    request.setAttribute("alert", "danger");
                    request.getRequestDispatcher("/views/web/comfirmFogotPass.jsp").forward(request, response);
                }
            }




        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);

    }
}
