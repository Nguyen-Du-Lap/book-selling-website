package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.BookModel;

import java.util.List;

public interface IProductService {
    List<BookModel> findAll();
    List<BookModel> find12Product();

    List<BookModel> findAllLimitOffset(int limit, int offset);

    int totalPage();
}
