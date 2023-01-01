package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.AuthorModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;

import java.util.List;

public interface ICustomerService {
    CustomerModel findByUsernameAndPasswordAndStatus(String email, String password, int status);
}
