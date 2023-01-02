package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.ShippingInfoModel;

import java.util.List;

public interface IBillService {
    int totalBill();
    List<ShippingInfoModel> shippingInfo();
}
