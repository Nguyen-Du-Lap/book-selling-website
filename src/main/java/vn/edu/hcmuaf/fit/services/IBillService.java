package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.ShippingInfoModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IBillService {
    int totalBill();
    List<ShippingInfoModel> shippingInfo();

    void addBill(int idUser, int idBook, String address, String city,
                 String district, String ward, int packInt, int payInt, int quantity,
                 double totalPriceShipVoucher, String info, String phone,int idCart,
                 HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    void removeProductInCart(List<Integer> listIdRemove, HttpServletRequest request);
}
