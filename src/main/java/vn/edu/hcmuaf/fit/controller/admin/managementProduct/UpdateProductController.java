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
@MultipartConfig
@WebServlet(name = "update-book", value = "/update-book")
public class UpdateProductController extends HttpServlet {
    @Inject
    IBookManagementService iBookManagementService;
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
        request.getRequestDispatcher("views/admin/table-data-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("discount"));

        Part part1 = request.getPart("image1");
        Part part2 = request.getPart("image2");
        Part part3 = request.getPart("image3");
        Part part4 = request.getPart("image4");

        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
        try {
            int i = iBookManagementService.update(idInt, name, quantity, price, discount);
            //add image
            if(part1 != null) iBookManagementService.addImage(request, response, part1, idInt);
            if(part2 != null) iBookManagementService.addImage(request, response, part2, idInt);
            if(part3 != null) iBookManagementService.addImage(request, response, part3, idInt);
            if(part4 != null) iBookManagementService.addImage(request, response, part4, idInt);
            if(i >= 1) {
                Log log = new Log(Log.WARNING,ip,"Quản lý sản phẩm",cus.getIdUser(),"Thay đổi thông tin sản phẩm",1);
                log.insert();
                response.sendRedirect("/admin-table-product?message=Upload success&alert=success");
            }else {
                response.sendRedirect("/admin-table-product?message=Upload success&alert=success");
            }
        }catch (Exception e) {
            request.getRequestDispatcher("/views/admin/table-data-product.jsp").forward(request, response);
        }

    }
}
