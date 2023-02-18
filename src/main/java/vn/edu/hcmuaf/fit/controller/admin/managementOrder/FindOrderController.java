package vn.edu.hcmuaf.fit.controller.admin.managementOrder;

import vn.edu.hcmuaf.fit.model.BillManagementModel;
import vn.edu.hcmuaf.fit.services.IBillManagementService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "findBill", value = "/findBill")
public class FindOrderController extends HttpServlet {
    @Inject
    IBillManagementService iBillManagementService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");

        if(id != null) {
            int idInt = Integer.parseInt(id);
            request.setAttribute("bill", iBillManagementService.findById(idInt));
            request.getRequestDispatcher("/views/admin/table-data-order-update.jsp").forward(request, response);


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
