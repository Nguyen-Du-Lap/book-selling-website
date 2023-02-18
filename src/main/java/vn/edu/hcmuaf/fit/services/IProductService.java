package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.BookDetails;
import vn.edu.hcmuaf.fit.model.BookModel;

import java.util.List;

public interface IProductService {
    List<BookModel> findAll();
    List<BookModel> find12Product();

    List<BookModel> findAllLimitOffset(int limit, int offset);

    int totalPage();

    BookModel findBookDetailById(int id);
    BookDetails findBookDetail1ById(int id);

    List<String> findAllImage(int id);

    List<BookModel> findAllLimitOffsetService(int page);

    List<BookModel> find12BookSearch(String key);

    List<BookModel> find12BookCatalog(int idInt);

    List<BookModel> find12BookPublisher(int idInt);

    int totalProduct();
    int outOfStock();

}
