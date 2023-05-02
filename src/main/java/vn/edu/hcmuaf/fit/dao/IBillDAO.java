package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.Bill;
import vn.edu.hcmuaf.fit.model.BookDetails;
import vn.edu.hcmuaf.fit.model.BookModel;
import vn.edu.hcmuaf.fit.model.ShippingInfoModel;

import java.util.List;

public interface IBillDAO {
    int totalBill();
    List<ShippingInfoModel> shippingInfo();
    List<Bill> findBillDeliverByIdOrder(int id);

    int cancelOrder(int idInt);
    List<Bill> findBillWarByIdOrder(int id);

    List<Bill> findBillDelivByIdOrder(int id);
    List<Bill> findBillRateByIdOrder(int id);

    List<Bill> findBillByIdOrder(int id);

    int rateBook(int idUser, int idBook, int idOrder, int start, String comment);
    int addBill(int idUser, int idBook, String address, int paymentMethod, int pack, int quantity,
            double totalPrice, String info, String phone,int idCart);
    BookDetails findByIdBook(int id);
}
