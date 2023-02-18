package vn.edu.hcmuaf.fit.controller.admin.managementOrder;

import vn.edu.hcmuaf.fit.services.IBillManagementService;
import vn.edu.hcmuaf.fit.services.IBookManagementService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "update-order", value = "/update-order")
public class UpdateOrderController extends HttpServlet {
    @Inject
    IBillManagementService iBillManagementService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");
        if(message != null && alert!= null) {
            request.setAttribute("message", message);
            request.setAttribute("alert", alert);
        }
        request.getRequestDispatcher("views/admin/table-data-order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String idOrder = request.getParameter("id_order");
        int idInt = Integer.parseInt(idOrder);
        String address = request.getParameter("address");
        String status = request.getParameter("shipping_info");
        Date shipdate;
        shipdate = (Date) request.getAttribute("ship_time");
        Date reveivedate = (Date) request.getAttribute("receive_time");
        try {
            int i = iBillManagementService.update(idInt, address, status, shipdate, reveivedate);
            if(i >= 1) {
                response.sendRedirect("/admin-table-order?message=Upload success&alert=success");
            }else {
                response.sendRedirect("/admin-table-order?message=Upload success&alert=success");
            }
        }catch (Exception e) {
            request.getRequestDispatcher("/views/admin/table-data-order.jsp").forward(request, response);
        }

    }
}
