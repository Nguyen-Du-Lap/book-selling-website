package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IBillDetailsDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDetailDAO;
import vn.edu.hcmuaf.fit.model.BillDetail;
import vn.edu.hcmuaf.fit.services.IBillDetailsService;

import java.util.List;


public class BillDetailService implements IBillDetailsService {
    IBillDetailsDAO iBillDetailsDAO = new BillDetailDAO();
    @Override
    public List<BillDetail> findAll() {
        return iBillDetailsDAO.findAll();
    }

    @Override
    public BillDetail findByID(int id) {
        return iBillDetailsDAO.findById(id);
    }
}
