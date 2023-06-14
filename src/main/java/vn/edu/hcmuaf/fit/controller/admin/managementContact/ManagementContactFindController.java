package vn.edu.hcmuaf.fit.controller.admin.managementContact;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.impl.ContactDao;
import vn.edu.hcmuaf.fit.model.ContactModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.EmailUtil;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet(name = "findContact", value = "/findContact")
public class ManagementContactFindController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("id");
            request.setAttribute("contact", new ContactDao().getContactById(Integer.parseInt(id)));
            request.getRequestDispatcher("views/admin/form-feedBack-contact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        ContactModel contactModel = new ContactDao().getContactById(Integer.parseInt(id));
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
        EmailUtil emailUtil = new EmailUtil();
        String content = request.getParameter("contentFeedBack");
        if(content != null && !content.isEmpty()) {
            emailUtil.sendEmailFeedBack(contactModel.getEmail(), contactModel.getFullName(), content);
            request.getSession().setAttribute("message", "Phản hồi thành công");
            request.getSession().setAttribute("alert", "success");
            new ContactDao().updateContact(contactModel.getId(), content);
            Log log = new Log(Log.INFO,ip,"Quản lí contact",cus.getIdUser(),"Nhân viên phản hồi khách hàng",1);
            log.insert();
            response.sendRedirect("admin-management-contact");
        } else {
            request.getSession().setAttribute("message", "Vui lòng nhập đầy đủ thông tin");
            request.getSession().setAttribute("alert", "success");
            response.sendRedirect("findContact");
        }

    }
}
