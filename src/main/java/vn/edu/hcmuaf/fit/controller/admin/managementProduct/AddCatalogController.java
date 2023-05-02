package vn.edu.hcmuaf.fit.controller.admin.managementProduct;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.IBookManagementDAO;
import vn.edu.hcmuaf.fit.dao.impl.BookManagementDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IBookManagementService;
import vn.edu.hcmuaf.fit.services.impl.BookManagementService;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet(name = "admin-add-catalog", value = "/admin-add-catalog")
public class AddCatalogController extends HttpServlet {
    IBookManagementService iBookManagementService = new BookManagementService();
    IBookManagementDAO iBookManagementDAO = new BookManagementDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");

        if(message != null & alert != null) {
            request.setAttribute("message", "Add success");
            request.setAttribute("alert", "success");
        }
        request.setAttribute("listCatalog", iBookManagementDAO.listCatalog());
        request.setAttribute("listPublisherCompany", iBookManagementDAO.listPublisherCompany());
        request.setAttribute("listPublisher", iBookManagementDAO.listPublisher());
        request.getRequestDispatcher("views/admin/table-data-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String catalog = request.getParameter("catalog");
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
        if(catalog != null) {
            if(iBookManagementService.insertCatalog(catalog)) {
                response.sendRedirect("/admin-add-san-pham?message=Add success&alert=success");
                Log log = new Log(Log.INFO,ip,"Quản lý sản phẩm",cus.getIdUser(),"Thêm mục lục sản phẩm",1);
                log.insert();
            }else {
                response.sendRedirect("/admin-add-san-pham?message=Add error&alert=danger");
            }
        }else  {
            response.sendRedirect("/admin-add-san-pham?message=Add error&alert=danger");

        }
    }
}
