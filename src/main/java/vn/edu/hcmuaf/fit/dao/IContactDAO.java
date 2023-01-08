package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.ContactModel;

import java.util.List;

public interface IContactDAO {
    List<ContactModel> findAllContact();

    ContactModel findById(int id);

    int update(int id, int status);


}
