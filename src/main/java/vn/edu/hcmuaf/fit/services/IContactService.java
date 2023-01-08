package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.ContactModel;

import java.util.List;

public interface IContactService {
    List<ContactModel> findAllContact();

    ContactModel findById(int id);
    int update(int id, int status);
}
