package vn.edu.hcmuaf.fit.controller.web.accounts;

import org.apache.poi.ss.formula.functions.Rate;
import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.dao.impl.CartDao;
import vn.edu.hcmuaf.fit.dao.impl.RateDAO;
import vn.edu.hcmuaf.fit.model.*;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "account", value = "/account")


public class AccountController extends HttpServlet {
    IBillDAO iBillDAO = new BillDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        if(cus == null) {
            response.sendRedirect("/login?action=login");
        }else {

            if (action != null) {
                if (action.equalsIgnoreCase("account")) {
                    request.setAttribute("cus", cus);
                    request.getRequestDispatcher("/views/web/account.jsp").forward(request, response);
                } else if (action.equalsIgnoreCase("changePassword")) {
                    request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
                } else if (action.equalsIgnoreCase("reviewOrders")) {
                    request.setAttribute("listBillDeliverByIdOrder", listDonHang(cus,1));
                    request.setAttribute("listBillWarByIdOrder",  listDonHang(cus,1));
                    request.setAttribute("listBillDelivByIdOrder",  listDonHang(cus,2));
                    request.setAttribute("listBillRateByIdOrder",  cartModelsChuaRate(cus,3));
                    request.setAttribute("listBillByIdOrder", listDonHang(cus,3));
                    request.getRequestDispatcher("/views/web/reviewOrders.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("cus", cus);
                request.getRequestDispatcher("/views/web/account.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public List<CartModel> listDonHang(CustomerModel cus, int info) {
        CartDao cartDao = new CartDao();
        List<CartModel> listModel = cartDao.getAllCartByIdUser(cus.getIdUser());
        for(int i =0 ;i < listModel.size();i++) {
            listModel.get(i).setBills(new BillDAO().findAllBillByIdCart( listModel.get(i).getId()));
        }
        List<CartModel> dangChoList = new ArrayList<>();
        for (int i =0;i<listModel.size();i++) {
            if(listModel.get(i).getInShip() == info) {
                dangChoList.add(listModel.get(i));
            }
        }
        return  dangChoList;
    }
    public List<CartModel> cartModelsChuaRate(CustomerModel cus, int info) {
        CartDao cartDao = new CartDao();
        List<CartModel> listModel = cartDao.getAllCartByIdUser(cus.getIdUser());
        for(int i =0 ;i < listModel.size();i++) {
            listModel.get(i).setBills(new BillDAO().findAllBillByIdCartRate( listModel.get(i).getId()));
        }
        List<CartModel> dangChoList = new ArrayList<>();
        for (int i =0;i<listModel.size();i++) {
            if(listModel.get(i).getInShip() == info && listModel.get(i).getBills().size() >0) {
                dangChoList.add(listModel.get(i));
            }
        }
        return  dangChoList;
    }
}
