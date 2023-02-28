package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.model.ShippingInfoModel;
import vn.edu.hcmuaf.fit.services.IBillService;
import vn.edu.hcmuaf.fit.utils.MessageParameterUntil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BillService implements IBillService {

    IBillDAO billDAO = new BillDAO();

    @Override
    public int totalBill() {
        return billDAO.totalBill();
    }

    @Override
    public List<ShippingInfoModel> shippingInfo() {
        return billDAO.shippingInfo();
    }

    @Override
    public void addBill(int idUser, int idBook, String address, String city, String district, String ward, int packInt, int payInt, int quantity, double totalPriceShipVoucher, String info,
                        String phone, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(payInt == 0){
            int checkAddBill = billDAO.addBill(idUser, idBook, address+", "+ward+", "+district+", "+city, packInt, payInt, quantity, totalPriceShipVoucher, info, phone);
            if(checkAddBill != 0) {
                new MessageParameterUntil("Mua hàng thành công", "success", "/views/web/reviewOrders.jsp", request, response).send();
            }else {
                new MessageParameterUntil("Mua hàng thât bại", "warning","/views/web/reviewOrders.jsp", request, response).send();
            }
        }
    }


}
