package vn.edu.hcmuaf.fit.controller.admin.managementProduct;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IBookManagementService;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet(urlPatterns = { "/deleteProduct"})
public class DeleteProductController extends HttpServlet {
    @Inject
    IBookManagementService bookManagement;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
            if(id != null) {
                int idInt = Integer.parseInt(id);
               bookManagement.deleteById(idInt);
                Log log = new Log(Log.WARNING,ip,"Quản lý sản phẩm",cus.getIdUser(),"Xóa sản phẩm",1);
                log.insert();
               response.sendRedirect(request.getContextPath()+"/admin-table-product");
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
