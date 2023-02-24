package vn.edu.hcmuaf.fit.controller.web.accounts;

import vn.edu.hcmuaf.fit.dao.impl.CustomerDAO;
import vn.edu.hcmuaf.fit.db.MessageProperties;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.model.EmailModel;
import vn.edu.hcmuaf.fit.utils.EmailUtil;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

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
                    EmailUtil sm = new EmailUtil();
                    String code = sm.getRandom();
                    CustomerDAO dao = new CustomerDAO();
                    CustomerModel user = dao.findByUsername(emailAddress);
                    user.setCode(code);
                   user.setTime_active_code( System.currentTimeMillis()/1000/60);
                    HttpSession session = request.getSession();
                    sm.sendEmail(user);
                    session.setAttribute("UserForgotPass", user);
                    session.setAttribute("attempts",3);

                    request.setAttribute("alert", "success");
                    request.getRequestDispatcher("/views/web/comfirmFogotPass.jsp").forward(request, response);
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
    public boolean sendEmail(CustomerModel user) {
        boolean test = false;

        String toEmail = user.getEmail();
        String fromEmail = "4tiensau@gmail.com";
        String password = "otfecajmjcaosged";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "587");
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.starttls.enable", "true");
//            pr.put("mail.smtp.socketFactory.port", "587");
//            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

            //set from email address
            mess.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            //set email subject
            mess.setSubject("User Email Verification");

            //set message text
            mess.setText("Registered successfully.Please verify your account using this code: " + user.getCode());
            //send the message
            Transport.send(mess);

            test=true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }

}
