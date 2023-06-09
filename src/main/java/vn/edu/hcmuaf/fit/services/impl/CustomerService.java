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
    public CustomerModel findById(int idUser) {
        return customerDAO.findById(idUser);
    }
    @Override
    public List<CustomerModel> findAllCustomer() {
        return customerDAO.findAllCustomer();
    }

    @Override
    public int update(int idUser, String firstName, String lastName, String phone, String address) {
        return customerDAO.update(idUser, firstName, lastName, phone, address);
    }

    @Override
    public CustomerModel findByUsername(String email) {
        return customerDAO.findByUsername(email);
    }

    public List<CustomerModel> getAllUserAdmin() {
        return customerDAO.getAllUserAdmin();
    }
}
