package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.ICustomerDAO;
import vn.edu.hcmuaf.fit.model.CustomerModel;
import vn.edu.hcmuaf.fit.services.ICustomerService;

import javax.inject.Inject;
import java.util.List;

public class CustomerService implements ICustomerService {

    @Inject
    ICustomerDAO customerDAO;
    @Override
    public CustomerModel findByUsernameAndPasswordAndStatus(String email, String password, int status) {
        return customerDAO.findByUsernameAndPasswordAndStatus(email, password, status);
    }

    @Override
    public int totalCustomer() {
        return customerDAO.totalCustomer();
    }

    @Override
    public List<CustomerModel> newCustomer() {
        return customerDAO.newCustomer();
    }
    @Override
    public CustomerModel findById(String idUser) {
        return customerDAO.findById(idUser);
    }
    @Override
    public List<CustomerModel> findAllCustomer() {
        return customerDAO.findAllCustomer();
    }
}
