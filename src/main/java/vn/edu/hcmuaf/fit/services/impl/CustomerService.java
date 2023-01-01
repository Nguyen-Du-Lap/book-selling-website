package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.ICustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.ICustomerService;

import javax.inject.Inject;

public class CustomerService implements ICustomerService {

    @Inject
    ICustomerDAO customerDAO;
    @Override
    public CustomerModel findByUsernameAndPasswordAndStatus(String email, String password, int status) {
        return customerDAO.findByUsernameAndPasswordAndStatus(email, password, status);
    }
}
