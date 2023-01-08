package vn.edu.hcmuaf.fit.dao.impl;

import vn.edu.hcmuaf.fit.dao.ICartDAO;
import vn.edu.hcmuaf.fit.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class CartDAO implements ICartDAO {
    List<ItemModel> items = new ArrayList<>();
    @Override
    public ItemModel getItemByID(int id) {
        return null;
    }

    @Override
    public int getQuantityById(int id) {
        return 0;
    }

    @Override
    public void addItem(ItemModel i) {

    }
}
