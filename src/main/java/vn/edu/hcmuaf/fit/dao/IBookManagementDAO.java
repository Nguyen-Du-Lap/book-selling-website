package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.BookManagementModel;

import java.util.List;

public interface IBookManagementDAO {
    List<BookManagementModel> findAllBook();
}
