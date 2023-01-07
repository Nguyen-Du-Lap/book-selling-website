package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.BookManagementModel;

import java.util.List;

public interface IBookManagementDAO {
    List<BookManagementModel> findAllBook();
    void deleteById(String id);

    BookManagementModel findById(String id);
    int update(String id, String name, int quantity, double price);
    List<String> listCatalog();

    List<String> listPublisherCompany();

}
