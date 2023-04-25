package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IBillManagementDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillManagementDAO;
import vn.edu.hcmuaf.fit.model.BillManagementModel;
import vn.edu.hcmuaf.fit.services.IBillManagementService;

import java.util.Date;
import java.util.List;

public class BillManagementService implements IBillManagementService {
    IBillManagementDAO iBillManagementDAO = new BillManagementDAO();

    @Override
    public List<BillManagementModel> findAll() {
        return iBillManagementDAO.findAllBill();
    }

    @Override
    public BillManagementModel findById(int id) {
        return iBillManagementDAO.findById(id);
    }

    @Override
    public int update(int id, String address, String status, Date shipTime, Date receiveTime) {
        return iBillManagementDAO.update(id, address, status, shipTime, receiveTime);
    }

    @Override
    public List<BillManagementModel> findAllBillConfrim() {
        return iBillManagementDAO.findAllBillConfrim();
    }

    @Override
    public void confirmBill(String id_order) {
         iBillManagementDAO.confirmBill(id_order);
    }

    @Override
    public void deleteBill(String id_order) { iBillManagementDAO.deleteBill(id_order);

    }


}
