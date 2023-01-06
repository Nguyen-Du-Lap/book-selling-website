package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.AuthorModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;

import java.util.List;

public interface ICustomerService {
    CustomerModel findByUsernameAndPasswordAndStatus(String email, String password, int status);
    int totalCustomer();
    List<CustomerModel> newCustomer();
    CustomerModel findById(String id);
    List<CustomerModel> findAllCustomer();
}
