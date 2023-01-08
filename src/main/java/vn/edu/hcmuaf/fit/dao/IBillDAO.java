package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.ShippingInfoModel;

import java.util.List;

public interface IBillDAO {
    int totalBill();
    List<ShippingInfoModel> shippingInfo();
}
