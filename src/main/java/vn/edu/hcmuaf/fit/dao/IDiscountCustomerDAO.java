package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.DiscountCustomerModel;

import java.util.List;

public interface IDiscountCustomerDAO {
    public List<DiscountCustomerModel> listDiscountCus(int idUser, double totalPrice);
    boolean checkIdVoucherInCus(int idVoucher, int idUser);

    List<DiscountCustomerModel> findDisByIdVou(int idUser, int idVoucher);
}
