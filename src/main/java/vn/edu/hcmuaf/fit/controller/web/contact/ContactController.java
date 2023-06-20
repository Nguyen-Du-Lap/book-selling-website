package vn.edu.hcmuaf.fit.controller.web.contact;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.impl.ContactDao;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet(name = "contact", value = "/contact")
public class ContactController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/views/web/contact.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ContactDao dao = new ContactDao();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String content = request.getParameter("content");
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
        if(name != null && email != null && phone != null && content != null && !name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !content.isEmpty()) {
            String message;
            String messageType;
            int check =  dao.insertContact(cus.getIdUser(), name,phone,email,content, 0);
            if(check > 0) {
                Log log = new Log(Log.WARNING,ip,"Phản hổi từ khách hàng",cus.getIdUser(),content,1);
                log.insert();
                System.out.println(content);
                message = "Gửi thành công";
                messageType = "success";
            }else {
                message = "Gủi thất bại";
                messageType = "danger";
            }
            request.getSession().setAttribute("message", message);
            request.getSession().setAttribute("alert", messageType);
            request.getRequestDispatcher("/views/web/contact.jsp").forward(request, response);

        } else {
            request.getSession().setAttribute("message", "Vui lòng nhập đầy đủ thông tin");
            request.getSession().setAttribute("alert", "danger");
            request.getRequestDispatcher("/views/web/contact.jsp").forward(request, response);
        }
    }

}