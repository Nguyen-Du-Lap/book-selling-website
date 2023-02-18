package vn.edu.hcmuaf.fit.controller.admin.managementOrder;

import vn.edu.hcmuaf.fit.model.BillDetail;
import vn.edu.hcmuaf.fit.model.BookManagementModel;
import vn.edu.hcmuaf.fit.services.IBillDetailsService;
import vn.edu.hcmuaf.fit.services.IBookManagementService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "findDetail", value = "/findDetail")
public class FindOrderDetailController extends HttpServlet {
    @Inject
    IBillDetailsService iBillDetailsService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");

        if(id != null) {
            int idInt = Integer.parseInt(id);
            List<BillDetail> list = new ArrayList<>();
            list.add(iBillDetailsService.findByID(idInt));
            request.setAttribute("listItem", list);
            request.getRequestDispatcher("/views/admin/management_order_details.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
