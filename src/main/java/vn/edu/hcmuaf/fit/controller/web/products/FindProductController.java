package vn.edu.hcmuaf.fit.controller.web.products;

import vn.edu.hcmuaf.fit.dao.IBookDAO;
import vn.edu.hcmuaf.fit.dao.impl.BookDAO;
import vn.edu.hcmuaf.fit.services.IProductService;
import vn.edu.hcmuaf.fit.services.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "productList", value = "/productList")
public class FindProductController extends HttpServlet {
    IBookDAO iBookDAO = new BookDAO();
    IProductService iProductService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        switch (type){
            case "allBookTop":
                request.setAttribute("list12Book", iBookDAO.listBookPayTopInProduct());
                break;
            case "allBookNew":
                request.setAttribute("list12Book", iBookDAO.listBookNewInProduct());
                break;
            case "allUpcoming":
                request.setAttribute("list12Book", iBookDAO.listBookReissueInProduct());
                break;
        }
        request.setAttribute("totalPage", iProductService.totalPage());
        request.setAttribute("currentPage", 1);
        request.getRequestDispatcher("/views/web/product.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
