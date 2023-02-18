package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IProductDAO;
import vn.edu.hcmuaf.fit.dao.impl.ProductDAO;
import vn.edu.hcmuaf.fit.model.BookDetails;
import vn.edu.hcmuaf.fit.model.BookModel;
import vn.edu.hcmuaf.fit.services.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductDAO iProductDAO = new ProductDAO();

    @Override
    public List<BookModel> findAll() {
        return iProductDAO.findAll();
    }

    @Override
    public List<BookModel> find12Product() {
        return iProductDAO.find12Book();
    }

    @Override
    public List<BookModel> findAllLimitOffset(int limit, int offset) {
        return iProductDAO.findAllLimitOffset(limit, offset);
    }

    @Override
    public int totalPage() {
        int total = iProductDAO.findAll().size();
        if (total % 12 == 0) return total / 12;
        return (total / 12)+1;
    }

    @Override
    public BookModel findBookDetailById(int id) {
        return iProductDAO.findBookDetailById(id);
    }

    @Override
    public BookDetails findBookDetail1ById(int id) {
        return iProductDAO.findBookDetail1ById(id);
    }

    @Override
    public List<String> findAllImage(int id) {
        return iProductDAO.findAddImage(id);
    }

    @Override
    public List<BookModel> findAllLimitOffsetService(int page) {
        int first = (page-1) * 12;
        int last = 0;
        if (findAll().size() - first >= 12)
        {
            last = 12;
        }else
        {
            last = findAll().size() % 12;
        }
        return findAllLimitOffset(first, last);
    }

    @Override
    public List<BookModel> find12BookSearch(String key) {
        return iProductDAO.find12BookSearch(key);
    }

    @Override
    public List<BookModel> find12BookCatalog(int idInt) {
        return iProductDAO.find12BookCatalog(idInt);
    }

    @Override
    public List<BookModel> find12BookPublisher(int idInt) {
        return iProductDAO.find12BookPublisher(idInt);
    }

    @Override
    public int totalProduct() {
        return iProductDAO.totalProduct();
    }

    @Override
    public int outOfStock() {
        return iProductDAO.outOfStock();
    }


    //Giỏ hàng

}
