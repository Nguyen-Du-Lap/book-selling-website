package vn.edu.hcmuaf.fit.controller.admin.managementRate;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.model.BillManagementModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IBillManagementService;
import vn.edu.hcmuaf.fit.services.IRateManagementService;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.InetAddress;
import java.util.*;

@WebServlet(name = "findRate", value = "/findRate")
public class FindRateController extends HttpServlet {
    @Inject
    IRateManagementService iRateManagementService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // title dung de active aside
        String id = request.getParameter("id");
        String book = request.getParameter("book");
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();

        iRateManagementService.hiddenRate(id,book);
        Log log = new Log(Log.INFO,ip,"Quản lý đánh giá, bình luận",cus.getIdUser(),"Ẩn bình luận",1);
        log.insert();

        request.setAttribute("message","Ẩn thành công");
        response.sendRedirect(request.getContextPath() + "/admin-manage-rate");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
