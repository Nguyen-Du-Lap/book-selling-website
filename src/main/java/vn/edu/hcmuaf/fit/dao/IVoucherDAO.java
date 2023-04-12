package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.VoucherModel;

import java.util.List;

public interface IVoucherDAO {
    List<VoucherModel> findAllVoucherById(int idUser);

    int getPriceVoucher(int idVoucher);

    void saveVoucherCus(int id, int idCus);

    void updateVoucher(int id);
}
