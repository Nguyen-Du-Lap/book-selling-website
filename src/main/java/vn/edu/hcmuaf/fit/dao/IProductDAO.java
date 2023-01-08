package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.BookDetails;
import vn.edu.hcmuaf.fit.model.BookModel;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<BookModel> findAll();
    List<BookModel> find12Book();

    List<BookModel> findAllLimitOffset(int limit, int offset);
    BookModel findBookDetailById(int id);

    BookDetails findBookDetail1ById(int id);
}
