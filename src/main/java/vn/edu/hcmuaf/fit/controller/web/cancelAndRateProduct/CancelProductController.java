package vn.edu.hcmuaf.fit.controller.web.cancelAndRateProduct;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.dao.impl.CartDao;
import vn.edu.hcmuaf.fit.model.CartModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.utils.MessageParameterUntil;
import vn.edu.hcmuaf.fit.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cancelOrder", value = "/cancelOrder")
public class CancelProductController extends HttpServlet {
    IBillDAO iBillDAO = new BillDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerModel cus = (CustomerModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        int result = iBillDAO.cancelOrder(idInt);
        InetAddress myIP=InetAddress.getLocalHost();
        String ip= myIP.getHostAddress();
        if(result > 0) {
            request.setAttribute("listBillDeliverByIdOrder", listDonHang(cus,1));
            request.setAttribute("listBillWarByIdOrder",  listDonHang(cus,1));
            request.setAttribute("listBillDelivByIdOrder",  listDonHang(cus,2));
            request.setAttribute("listBillRateByIdOrder",  listDonHang(cus,3));
            request.setAttribute("listBillByIdOrder", listDonHang(cus,3));
            CartDao dao = new CartDao();
            dao.updateCart(idInt, 4);
            Log log = new Log(Log.ALER,ip,"Cancel Product", cus.getIdUser(),"Customer cancel product: "+ id,1);
            log.insert();
            new MessageParameterUntil("Hủy đơn hàng thành công", "success", "/views/web/reviewOrders.jsp", request, response).send();

        }else {
            new MessageParameterUntil("Hủy đơn hàng thất bại", "danger", "/views/web/reviewOrders.jsp", request, response).send();
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
}
