package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.BillManagementModel;

import java.util.Date;
import java.util.List;

public interface IBillManagementService {
    List<BillManagementModel> findAll();
    BillManagementModel findById(int id);

    int update(int id, String address, String status, Date shipTime, Date receiveTime);

}
