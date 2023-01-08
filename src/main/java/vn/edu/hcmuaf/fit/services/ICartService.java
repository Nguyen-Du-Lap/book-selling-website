package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.ItemModel;

public interface ICartService {
    ItemModel getItemById(int id);

    int getQuantityById(int id);

    void addItem(ItemModel i);
}
