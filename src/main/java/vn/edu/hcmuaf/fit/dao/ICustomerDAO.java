package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.AuthorModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;

import java.util.List;

public interface ICustomerDAO {
    CustomerModel findByUsernameAndPasswordAndStatus(String email, String password, int status);

    CustomerModel checkAccountExist(String email);

    int totalCustomer();

    List<CustomerModel> newCustomer();

    CustomerModel findById(String idUser);

    List<CustomerModel> findAllCustomer();
}
