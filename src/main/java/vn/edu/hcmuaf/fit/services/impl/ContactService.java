package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IContactDAO;
import vn.edu.hcmuaf.fit.model.ContactModel;
import vn.edu.hcmuaf.fit.services.IContactService;

import javax.inject.Inject;
import java.util.List;

public class ContactService implements IContactService {
    @Inject
    IContactDAO contactDAO;
    @Override
    public List<ContactModel> findAllContact() {
        return contactDAO.findAllContact();
    }

    @Override
    public ContactModel findById(int id) {
        return contactDAO.findById(id);
    }
    @Override
    public int update(int id, int status) {
        return contactDAO.update(id, status);
    }
}
