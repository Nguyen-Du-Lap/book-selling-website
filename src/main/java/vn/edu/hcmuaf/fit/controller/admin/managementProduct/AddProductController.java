package vn.edu.hcmuaf.fit.controller.admin.managementProduct;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.IBookManagementDAO;
import vn.edu.hcmuaf.fit.dao.impl.BookManagementDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.IBookManagementService;
import vn.edu.hcmuaf.fit.services.impl.BookManagementService;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Path;
import java.nio.file.Paths;

@MultipartConfig
@WebServlet(name = "admin-add-san-pham", value = "/admin-add-san-pham")
public class AddProductController extends HttpServlet {
    IBookManagementDAO iBookManagementDAO = new BookManagementDAO();

    IBookManagementService iBookManagementService = new BookManagementService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");
        if( message != null && alert != null) {
            request.setAttribute("message", message);
            request.setAttribute("alert", alert);
        }
        request.setAttribute("listCatalog", iBookManagementDAO.listCatalog());
        request.setAttribute("listPublisherCompany", iBookManagementDAO.listPublisherCompany());
        request.setAttribute("listPublisher", iBookManagementDAO.listPublisher());
        request.getRequestDispatcher("views/admin/form-add-san-pham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            String name = request.getParameter("name");
            String quantity = request.getParameter("quantity");
            String status = request.getParameter("status");
            String isNew = request.getParameter("isNew");
            String catalog = request.getParameter("catalog");
            String publisherCompany = request.getParameter("publisherCompany");
            String publisher = request.getParameter("publisher");
            String primeCost = request.getParameter("primeCost");
            String price = request.getParameter("price");
            String isbn = request.getParameter("isbn");
            String year = request.getParameter("year");
            String weight = request.getParameter("weight");
            String size = request.getParameter("size");
            String page = request.getParameter("page");
            String language = request.getParameter("language");
            String description = request.getParameter("description");

            Part part1 = request.getPart("image1");
            Part part2 = request.getPart("image2");
            Part part3 = request.getPart("image3");
            Part part4 = request.getPart("image4");
            CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
            InetAddress myIP=InetAddress.getLocalHost();
            String ip= myIP.getHostAddress();

            if(name != null && quantity != null && price != null && primeCost != null) {

                    int quantityInt = Integer.parseInt(quantity);
                    double priceDouble = Double.parseDouble(price);
                    double primeCostDouble = Double.parseDouble(primeCost);
                    double weightDouble = Double.parseDouble(weight);
                    int pageInt = Integer.parseInt(page);
                    int yearIn = Integer.parseInt(year);

                    if(!iBookManagementService.checkNameBook(name)) {
                        //add book và book details
                        boolean checkInsert = iBookManagementService
                                .addBook(name, quantityInt, status, isNew, catalog, publisherCompany
                                        ,priceDouble, primeCostDouble, isbn, yearIn, weightDouble, size, pageInt,
                                        language, description , publisher);
                        if(checkInsert) {
                            int id = iBookManagementDAO.findIdByName(name);
                            //add image
                            if(part1 != null) iBookManagementService.addImage(request, response, part1, id);
                            if(part2 != null) iBookManagementService.addImage(request, response, part2, id);
                            if(part3 != null) iBookManagementService.addImage(request, response, part3, id);
                            if(part4 != null) iBookManagementService.addImage(request, response, part4, id);
                            Log log = new Log(Log.INFO,ip,"Quản lý sản phẩm",cus.getIdUser(),"Thêm sản phẩm",1);
                            log.insert();
                            response.sendRedirect("/admin-add-san-pham?message=Them thanh cong&alert=success");
                        }else {
                            response.sendRedirect("/admin-add-san-pham?message=Them that bai&alert=danger");
                        }
                    }else  {
                        response.sendRedirect("/admin-add-san-pham?message=Ten sach da ton tai&alert=danger");
                    }

            }else {
                response.sendRedirect("/admin-add-san-pham?message=Vui long nhap thong tin can thiet&alert=warning");
            }
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/admin-add-san-pham?message=Vui long nhap thong tin can thiet&alert=warning");
        }

    }
}
