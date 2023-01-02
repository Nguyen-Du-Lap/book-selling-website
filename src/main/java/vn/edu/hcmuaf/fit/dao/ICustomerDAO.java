package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.AuthorModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;

import java.util.List;

public interface ICustomerDAO {
    CustomerModel findByUsernameAndPasswordAndStatus(String email, String password, int status);
    int totalCustomer();

    List<CustomerModel> newCustomer();
}
