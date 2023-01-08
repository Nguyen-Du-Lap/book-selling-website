package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.ItemModel;

public interface ICartDAO {

    ItemModel getItemByID(int id);

    int getQuantityById(int id);

    void addItem(ItemModel i);

}
