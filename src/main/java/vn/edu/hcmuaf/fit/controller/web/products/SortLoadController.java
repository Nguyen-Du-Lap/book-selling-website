package vn.edu.hcmuaf.fit.controller.web.products;

import vn.edu.hcmuaf.fit.model.CatalogModel;
import vn.edu.hcmuaf.fit.services.ICatalogService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "sort-load", value = "/sort-load")
public class SortLoadController extends HttpServlet {
    @Inject
    ICatalogService catalogService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pageStr = request.getParameter("page");
        String limitSrt = request.getParameter("limit");
        String valueSort = request.getParameter("valueSort");
        int limit;
        int page;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        } else {
            // mat dinh trang 1
            page = 1;
        }
        if (limitSrt != null) {
            limit = Integer.parseInt(limitSrt);
        } else {
            limit = 4;
        }
        List<CatalogModel> listCatalog = catalogService.findAllSort(3, 9, "id_catalog", "DESC");

//        if (valueSort != null) {
//            if (valueSort.equals("macdinh")) {
//                listCatalog = catalogService.findAllTest((page - 1) * limit, limit);
//            }
//            if(valueSort.equals("cao-thap")) {
//                listCatalog = catalogService.findAllSort((page - 1) * limit, limit, "id_catalog", "DESC");
//            }
//            if(valueSort.equals("thap-cao")) {
//                listCatalog = catalogService.findAllSort((page - 1) * limit, limit, "id_catalog", "ASC");
//            }
//            //        List<CatalogModel> listCatalog = catalogService.findAll();
//            PrintWriter out = response.getWriter();
//            for (CatalogModel o : listCatalog) {
//                out.println("<div class=\"col-lg-3 col-md-4 col-xs-6 item victo-hugo\">\n" +
//                        "                                    <div class=\"card\">\n" +
//                        "                                        <a href=\"Product_detail.html\" class=\"motsanpham\"\n" +
//                        "                                           data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Những người khốn khổ\">\n" +
//                        "                                            <img class=\"card-img-top anh\"\n" +
//                        "                                                 src=\"/templates/images/vanhocnuocngoai/nhungnguoikhonkho1.jpeg\"\n" +
//                        "                                                 alt=\"Những người khốn khổ\">\n" +
//                        "                                            <div class=\"card-body noidungsp mt-3\">\n" +
//                        "                                                <h6 class=\"card-title ten\">" + o.getIdCatalog() + "</h6>\n" +
//                        "                                                <small class=\"tacgia text-muted\" style=\"font-weight: bold\">Victo\n" +
//                        "                                                    Hugo</small>\n" +
//                        "                                                <div class=\"card-price d-flex align-items-baseline\">\n" +
//                        "                                                    <div class=\"giamoi\">273.000đ <br></div>\n" +
//                        "                                                    <div class=\"giacu text-muted\"> 390.000đ</div>\n" +
//                        "                                                </div>\n" +
//                        "                                            </div>\n" +
//                        "                                            <div class=\"danhgia\">\n" +
//                        "                                                <ul class=\"d-flex\" style=\"list-style: none\">\n" +
//                        "                                                    <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
//                        "                                                    <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
//                        "                                                    <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
//                        "                                                    <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
//                        "                                                    <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
//                        "                                                    <li><span class=\"text-muted\">  20 nhận xét</span></li>\n" +
//                        "                                                </ul>\n" +
//                        "                                            </div>\n" +
//                        "                                        </a>\n" +
//                        "                                    </div>\n" +
//                        "                                </div>");
//            }
//        }
        PrintWriter out = response.getWriter();
        for (CatalogModel o : listCatalog) {
            out.println("<div class=\"col-lg-3 col-md-4 col-xs-6 item victo-hugo\">\n" +
                    "                                    <div class=\"card\">\n" +
                    "                                        <a href=\"Product_detail.html\" class=\"motsanpham\"\n" +
                    "                                           data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Những người khốn khổ\">\n" +
                    "                                            <img class=\"card-img-top anh\"\n" +
                    "                                                 src=\"/templates/images/vanhocnuocngoai/nhungnguoikhonkho1.jpeg\"\n" +
                    "                                                 alt=\"Những người khốn khổ\">\n" +
                    "                                            <div class=\"card-body noidungsp mt-3\">\n" +
                    "                                                <h6 class=\"card-title ten\">" + o.getIdCatalog() + "</h6>\n" +
                    "                                                <small class=\"tacgia text-muted\" style=\"font-weight: bold\">Victo\n" +
                    "                                                    Hugo</small>\n" +
                    "                                                <div class=\"card-price d-flex align-items-baseline\">\n" +
                    "                                                    <div class=\"giamoi\">273.000đ <br></div>\n" +
                    "                                                    <div class=\"giacu text-muted\"> 390.000đ</div>\n" +
                    "                                                </div>\n" +
                    "                                            </div>\n" +
                    "                                            <div class=\"danhgia\">\n" +
                    "                                                <ul class=\"d-flex\" style=\"list-style: none\">\n" +
                    "                                                    <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                    <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                    <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                    <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                    <li class=\"active\"><i class=\"fa fa-star\"></i></li>\n" +
                    "                                                    <li><span class=\"text-muted\">  20 nhận xét</span></li>\n" +
                    "                                                </ul>\n" +
                    "                                            </div>\n" +
                    "                                        </a>\n" +
                    "                                    </div>\n" +
                    "                                </div>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
