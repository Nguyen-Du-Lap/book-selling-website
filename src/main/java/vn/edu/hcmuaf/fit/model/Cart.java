package vn.edu.hcmuaf.fit.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<ItemModel> items;

    private Cart() {
        items=new ArrayList<>();
    }

    public Cart(List<ItemModel> items) {
        this.items = items;
    }

}
