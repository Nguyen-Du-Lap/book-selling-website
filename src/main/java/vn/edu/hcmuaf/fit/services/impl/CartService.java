package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.ICartDAO;
import vn.edu.hcmuaf.fit.dao.impl.CartDAO;
import vn.edu.hcmuaf.fit.model.ItemModel;
import vn.edu.hcmuaf.fit.services.ICartService;

public class CartService implements ICartService {
    ICartDAO iCartDAO = new CartDAO();

    @Override
    public ItemModel getItemById(int id) {
        return iCartDAO.getItemByID(id);
    }

    @Override
    public int getQuantityById(int id) {
        return iCartDAO.getQuantityById(id);
    }

    @Override
    public void addItem(ItemModel i) {
        iCartDAO.addItem(i);
    }
}
