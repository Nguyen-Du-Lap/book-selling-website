package vn.edu.hcmuaf.fit.services;


import vn.edu.hcmuaf.fit.model.RateModel;

import java.util.List;

public interface IRateManagementService {
     List<RateModel> getAll();
     void hiddenRate(String idOrder, String idBook);
     void activityRate(String idOrder, String idBook);
}
