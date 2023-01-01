package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.BookManagementModel;

import java.util.List;

public interface IBookManagementService {
    List<BookManagementModel> findAll();
}
