package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IProductDAO;
import vn.edu.hcmuaf.fit.services.IProductService;

import javax.inject.Inject;

public class ProductService implements IProductService {
    @Inject
    IProductDAO productDAO;
    @Inject
    IProductDAO bookDAO;

    @Override
    public int totalProduct() {
        return productDAO.totalProduct();
    }
    @Override
    public int outOfStock() {
        return bookDAO.outOfStock();
    }
}
