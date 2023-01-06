package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.BillManagementModel;

import java.util.List;

public interface IBillManagementService {
    List<BillManagementModel> findAll();
}
