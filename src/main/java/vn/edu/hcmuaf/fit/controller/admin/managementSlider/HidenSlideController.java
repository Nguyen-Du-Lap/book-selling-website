package vn.edu.hcmuaf.fit.controller.admin.managementSlider;

import vn.edu.hcmuaf.fit.model.BillManagementModel;
import vn.edu.hcmuaf.fit.services.IBillManagementService;
import vn.edu.hcmuaf.fit.services.IRateManagementService;
import vn.edu.hcmuaf.fit.services.ISliderManagementService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "findSlideHinden", value = "/findSlideHinden")
public class HidenSlideController extends HttpServlet {
    @Inject
    ISliderManagementService iSliderManagementService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // title dung de active aside
        String id = request.getParameter("id");
        iSliderManagementService.hiddenSilde(id);
        request.setAttribute("message","Hiện thành công");
        response.sendRedirect(request.getContextPath() + "/admin-table-slider");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
