package vn.edu.hcmuaf.fit.controller.web.cancelAndRateProduct;

import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.dao.IProductDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.dao.impl.ProductDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet(name = "rate", value = "/rate")
public class RateController extends HttpServlet {
    IBillDAO iBillDAO = new BillDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String idBook = request.getParameter("idBook");

        if(id != null) {
            request.setAttribute("idOrder", id);
            request.setAttribute("idBook", idBook);
        }
        request.getRequestDispatcher("views/web/rate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String comment = request.getParameter("comment");
        String idBill = request.getParameter("idBill");
        String idBook = request.getParameter("idBook");
        String numberStar = request.getParameterValues("numberStar")[0];
        int number = Integer.parseInt(numberStar);
        BufferedReader reader = request.getReader();
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        if(comment != null && idBill != null && idBook != null) {
            int idBookInt = Integer.parseInt(idBook);
            int idOrderInt = Integer.parseInt(idBill);
            int rate = iBillDAO.rateBook(cus.getIdUser(), idBookInt, idOrderInt, number, comment);
            if(rate >=1) {
                request.setAttribute("message", "Đánh giá thành công");
                request.setAttribute("alert", "success");
            }else {
                request.setAttribute("message", "Đánh giá thất bại");
                request.setAttribute("alert", "danger");
            }
        }
        request.getRequestDispatcher("views/web/reviewOrders.jsp").forward(request, response);
    }
}
