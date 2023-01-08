package vn.edu.hcmuaf.fit.controller.admin.managementCustomer;

import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.ICustomerService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "findCustomer", value = "/findCustomer")
public class FindCustomerController extends HttpServlet {
    @Inject
    ICustomerService iCustomerService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUser = request.getParameter("idUser");

        if (idUser != null) {
            List<CustomerModel> list = new ArrayList<>();
            list.add(iCustomerService.findById(Integer.parseInt(idUser)));
            request.setAttribute("customerUpdate", list);
            request.getRequestDispatcher("/views/admin/table-data-customer-update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
