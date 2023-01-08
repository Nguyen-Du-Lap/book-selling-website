package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IProductDAO;
import vn.edu.hcmuaf.fit.dao.impl.ProductDAO;
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
}
