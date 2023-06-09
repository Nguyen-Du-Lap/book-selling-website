package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.AuthorModel;
import vn.edu.hcmuaf.fit.model.CustomerModel;

import java.util.List;

public interface ICustomerDAO {
    CustomerModel findByUsernameAndPasswordAndStatus(String email, String password, int status);

    CustomerModel checkAccountExist(String email);

    int totalCustomer();

    List<CustomerModel> newCustomer();

    List<CustomerModel> findAllCustomer();

    CustomerModel findById(int idUser);

    int update(int idUser, String firstName, String lastName, String phone, String address);

    CustomerModel findByUsername(String email);

    void changePassWord(String email, String password);
    List<CustomerModel> getAllUserAdmin();

}
