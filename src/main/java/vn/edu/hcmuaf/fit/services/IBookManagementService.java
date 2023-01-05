package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.BookManagementModel;

import java.util.List;

public interface IBookManagementService {
    List<BookManagementModel> findAll();
    void deleteById(String id);
    BookManagementModel findById(String id);
    int update(String id, String name, int quantity, double price);

}
