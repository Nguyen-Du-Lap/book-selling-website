package vn.edu.hcmuaf.fit.controller.web.products;

import vn.edu.hcmuaf.fit.model.BookModel;
import vn.edu.hcmuaf.fit.model.CatalogModel;
import vn.edu.hcmuaf.fit.services.ICatalogService;
import vn.edu.hcmuaf.fit.services.IProductService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "paging-load", value = "/paging-load")
public class PagingLoadController extends HttpServlet {
    @Inject
    private IProductService iProductService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pageStr = request.getParameter("page");
        String limitSrt = request.getParameter("limit");
        int limit;
        int page;
        if(pageStr != null) {
            page = Integer.parseInt(pageStr);
        }else {
            // mat dinh trang 1
            page = 1;
        }
        if(limitSrt != null) {
            limit = Integer.parseInt(limitSrt);
        } else {
            limit = 4;
        }
        List<BookModel> listBook = iProductService.findAllLimitOffset((page-1) * limit , limit);
//        List<CatalogModel> listCatalog = catalogService.findAll();
        PrintWriter out = response.getWriter();
        for(BookModel o : listBook) {
            out.println("<div class=\"col-lg-3 col-md-4 col-xs-6 item victo-hugo\">\n" +
                    "                                        <div class=\"card\">\n" +
                    "                                            <a href=\"/products/product-detail?id="+o.getIdBook()+"\" class=\"motsanpham\"\n" +
                    "                                               data-toggle=\"tooltip\" data-placement=\"bottom\" title=\""+ o.getName()+"\">\n" +
                    "                                                <img class=\"card-img-top anh\"\n" +
                    "                                                     src=\""+o.getImage()+"\"\n" +
                    "                                                     alt=\""+o.getImage()+"\">\n" +
                    "                                                <div class=\"card-body noidungsp mt-3\">\n" +
                    "                                                    <h6 class=\"card-title ten\">"+ o.getName()+"</h6>\n" +
                    "                                                    <small class=\"tacgia text-muted\" style=\"font-weight: bold\">"+ o.getNameAuthor()+"</small>\n" +
                    "                                                    <div class=\"card-price d-flex align-items-baseline\">\n" +
                    "                                                        <div class=\"giamoi\">"+ o.getPriceDiscount()+"đ <br></div>\n" +
                    "                                                        <div class=\"giacu text-muted\">"+ o.getPrice()+"đ</div>\n" +
                    "                                                    </div>\n" +
                    "                                                </div>\n" +
                    "                                                <div class=\"danhgia\">\n" +
                    "                                                    <ul class=\"d-flex\" style=\"list-style: none\">\n" +
                    "                                                        <c:if test=\"${"+o.getQuantityStart()+" == 5}\">\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                        </c:if>\n" +
                    "                                                        <c:if test=\"${"+o.getQuantityStart()+" == 4}\">\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                        </c:if>\n" +
                    "\n" +
                    "                                                        <c:if test=\"${"+o.getQuantityStart()+" == 3}\">\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                        </c:if>\n" +
                    "\n" +
                    "                                                        <c:if test=\"${"+o.getQuantityStart()+" == 2}\">\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                        </c:if>\n" +
                    "\n" +
                    "                                                        <c:if test=\"${"+o.getQuantityStart()+" == 1}\">\n" +
                    "                                                            <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                        </c:if>\n" +
                    "                                                        <c:if test=\"${"+o.getQuantityStart()+" == 0}\">\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                            <li class=\"\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                        </c:if>\n" +
                    "                                                    </ul>\n" +
                    "                                                    <span class=\"text-muted\">"+o.getQuantityComment()+" nhận xét</span>\n" +
                    "                                                </div>\n" +
                    "                                            </a>\n" +
                    "                                        </div>\n" +
                    "                                    </div>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
