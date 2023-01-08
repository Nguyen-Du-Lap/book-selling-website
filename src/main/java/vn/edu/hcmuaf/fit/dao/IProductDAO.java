package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.BookModel;

import java.util.List;

public interface IProductDAO {
    List<BookModel> findAll();
    List<BookModel> find12Book();

    List<BookModel> findAllLimitOffset(int limit, int offset);
}
