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

    @Override
    public void deleteById(String id) {
        iBookManagementDAO.deleteById(id);
    }

    @Override
    public BookManagementModel findById(String id) {
        return iBookManagementDAO.findById(id);
    }

    @Override
    public int update(String id, String name, int quantity, double price) {
        return iBookManagementDAO.update(id, name, quantity, price);
    }
}
