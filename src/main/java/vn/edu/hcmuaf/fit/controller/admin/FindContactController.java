package vn.edu.hcmuaf.fit.controller.admin;

import vn.edu.hcmuaf.fit.model.BookManagementModel;
import vn.edu.hcmuaf.fit.model.ContactModel;
import vn.edu.hcmuaf.fit.services.IContactService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "findContact", value = "/findContact")
public class FindContactController extends HttpServlet {
    @Inject
    IContactService iContactService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");

        if(id != null) {
            List<ContactModel> list = new ArrayList<>();
            list.add(iContactService.findById(Integer.parseInt(id)));
            request.setAttribute("contactUpdate", list);
            request.getRequestDispatcher("/views/admin/management-contact-update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
