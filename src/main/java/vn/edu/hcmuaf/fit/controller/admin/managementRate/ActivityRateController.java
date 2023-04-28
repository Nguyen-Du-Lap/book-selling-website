package vn.edu.hcmuaf.fit.controller.admin.managementRate;

import vn.edu.hcmuaf.fit.model.BillManagementModel;
import vn.edu.hcmuaf.fit.services.IBillManagementService;
import vn.edu.hcmuaf.fit.services.IRateManagementService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "findRateAvtivity", value = "/findRateAvtivity")
public class ActivityRateController extends HttpServlet {
    @Inject
    IRateManagementService iRateManagementService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // title dung de active aside
        String id = request.getParameter("id");
        String book = request.getParameter("book");
        iRateManagementService.activityRate(id,book);
        request.setAttribute("message","Hiện thành công");
        response.sendRedirect(request.getContextPath() + "/admin-manage-rate");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
