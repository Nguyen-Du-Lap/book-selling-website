package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.BillManagementModel;
import vn.edu.hcmuaf.fit.model.BillModel;

import java.util.Date;
import java.util.List;

public interface IBillManagementDAO {
    List<BillManagementModel> findAllBill();
    List<BillManagementModel> findAllBillConfrim();
    BillManagementModel findById(int id);

    int update(int id, String address, String status, Date shipTime, Date receiveTime);

    void create(BillModel bill);

    void confirmBill(String id_order);
    void deleteBill(String id_order);
}
