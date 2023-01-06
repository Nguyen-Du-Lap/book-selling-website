package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.BillManagementModel;

import java.util.List;

public interface IBillManagementDAO {
    List<BillManagementModel> findAllBill();
}
