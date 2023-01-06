package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.IBillManagementDAO;
import vn.edu.hcmuaf.fit.model.BillManagementModel;

import java.util.ArrayList;
import java.util.List;

public class BillDAO implements IBillManagementDAO {


    @Override
    public List<BillManagementModel> findAllBill() {
        List<BillManagementModel> result = new ArrayList<>();
        String sql = "SELECT  FROM bill"
        return null;
    }
}
