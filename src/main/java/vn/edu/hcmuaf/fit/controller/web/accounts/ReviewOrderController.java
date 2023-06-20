package vn.edu.hcmuaf.fit.controller.web.accounts;

import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.dao.impl.CartDao;
import vn.edu.hcmuaf.fit.model.*;
import vn.edu.hcmuaf.fit.utils.MessageParameterUntil;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "reviewOrder", value = "/order/reviewOrder")
public class ReviewOrderController extends HttpServlet {
    IBillDAO iBillDAO = new BillDAO();
    CartDao cartDao = new CartDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        String orderSuccess = request.getParameter("orderSuccess");
        List<CartModel> listModel = cartDao.getAllCartByIdUser(cus.getIdUser());
        for(int i =0 ;i < listModel.size();i++) {
            listModel.get(i).setBills(new BillDAO().findAllBillByIdCart( listModel.get(i).getId()));
        }
        List<CartModel> dangChoList = new ArrayList<>();
        for (int i =0;i<listModel.size();i++) {
            if(listModel.get(i).getInShip() == 1) {
                dangChoList.add(listModel.get(i));
            }
        }

        request.setAttribute("listBillDeliverByIdOrder", listDonHang(cus,1));
        request.setAttribute("listBillWarByIdOrder",  listDonHang(cus,1));
        request.setAttribute("listBillDelivByIdOrder",  listDonHang(cus,2));
        request.setAttribute("listBillRateByIdOrder",  cartModelsChuaRate(cus,3));
        request.setAttribute("listBillByIdOrder", listDonHang(cus,3));
        request.setAttribute("orderSuccess", orderSuccess);
        request.getRequestDispatcher("/views/web/reviewOrders.jsp").forward(request, response);


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
