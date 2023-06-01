package vn.edu.hcmuaf.fit.controller.admin.managementProduct;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.IBookManagementDAO;
import vn.edu.hcmuaf.fit.model.BookManagementModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IBookManagementService;
import vn.edu.hcmuaf.fit.services.impl.BookManagementService;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "findProduct", value = "/findProduct")
public class FindProductController extends HttpServlet {
    IBookManagementService iBookManagementService = new BookManagementService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");

        if(id != null) {
            int idInt = Integer.parseInt(id);
            List<BookManagementModel> list = new ArrayList<>();
            list.add(iBookManagementService.findById(idInt));
            request.setAttribute("bookUpdate", list);
            request.getRequestDispatcher("/views/admin/table-data-product-update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
