package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IBillDAO;
import vn.edu.hcmuaf.fit.dao.IProductDAO;
import vn.edu.hcmuaf.fit.dao.impl.BillDAO;
import vn.edu.hcmuaf.fit.model.ShippingInfoModel;
import vn.edu.hcmuaf.fit.services.IBillService;

import javax.inject.Inject;
import java.util.List;

public class BillService implements IBillService {
    @Inject
    IBillDAO billDAO;

    @Override
    public int totalBill() {
        return billDAO.totalBill();
    }

    @Override
    public List<ShippingInfoModel> shippingInfo() {
        return billDAO.shippingInfo();
    }
}
