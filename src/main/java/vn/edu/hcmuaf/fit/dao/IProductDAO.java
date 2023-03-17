package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.BookDetails;
import vn.edu.hcmuaf.fit.model.BookModel;
import vn.edu.hcmuaf.fit.model.Product;

import java.util.List;

public interface IProductDAO {
    List<BookModel> findAll();
    List<BookModel> find12Book();

    List<BookModel> findAllLimitOffset(int limit, int offset);
    BookModel findBookDetailById(int id);

    BookDetails findBookDetail1ById(int id);

    List<String> findAddImage(int id);

    List<BookModel> find12BookSearch(String key);

    List<BookModel> find12BookCatalog(int idInt);

    List<BookModel> find12BookPublisher(int idInt);

    int totalProduct();

    int outOfStock();

    //Giỏ hàng
    Product getProductById(int parseInt);

    int getRemainQuantity(int idBook);

    void updateQuantity(int idBook, int i);

}
