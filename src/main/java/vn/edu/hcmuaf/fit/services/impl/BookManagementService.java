package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IBookManagementDAO;
import vn.edu.hcmuaf.fit.model.BookManagementModel;
import vn.edu.hcmuaf.fit.services.IBookManagementService;

import javax.inject.Inject;
import java.util.List;

public class BookManagementService implements IBookManagementService {
    @Inject
    IBookManagementDAO iBookManagementDAO;
    @Override
    public List<BookManagementModel> findAll() {
        return iBookManagementDAO.findAllBook();
    }
}
