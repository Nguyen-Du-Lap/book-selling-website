package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IRateDAO;
import vn.edu.hcmuaf.fit.dao.impl.RateDAO;
import vn.edu.hcmuaf.fit.model.RateModel;
import vn.edu.hcmuaf.fit.services.IRateManagementService;

import java.util.List;

public class RateManagementService implements IRateManagementService {
    IRateDAO iRateDAO = new RateDAO();
    @Override
    public List<RateModel> getAll() {
        return iRateDAO.listAll();
    }

    @Override
    public void hiddenRate(String idOrder, String idBook) {
        iRateDAO.hideRate(idOrder,idBook);
    }

    @Override
    public void activityRate(String idOrder, String idBook) {
        iRateDAO.actitvityRate(idOrder,idBook);
    }
}
