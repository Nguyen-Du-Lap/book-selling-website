package vn.edu.hcmuaf.fit.model;

import vn.edu.hcmuaf.fit.dao.impl.ProductDAO;

import java.io.Serializable;
import java.util.*;

public class Cart implements Serializable {
    private final Map<Integer, CartItem> map = new HashMap<>();

    private int count;
    private double totalPrice;

    public void addProduct(Product p, int quantity) {
        CartItem item = map.containsKey(p.getIdBook()) ? map.get(p.getIdBook()) : new CartItem(p);
        item.setQuantity(item.getQuantity() + quantity);
        map.put(p.getIdBook(), item);

    }

    public void removeProduct(Product p) {
        CartItem item = map.get(p.getIdBook());
        if (item.getQuantity() == 1) map.remove(p.getIdBook());
        else item.setQuantity(item.getQuantity() - 1);
    }

    public void deleteProduct(Product p) {
        map.remove(p.getIdBook());
    }
    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public int getCount() {
        count = 0;
        map.forEach((id, item) -> count += item.getQuantity());
        return count;
    }

    public double getTotalPrice() {
        totalPrice = 0;
        map.forEach((id, item) -> totalPrice += item.getProduct().getPriceDiscount() * item.getQuantity());
        return totalPrice;
    }

//    public void invalidate() {
//        final var dao = new ProductDAO();
//        map.forEach((id, cartItem) ->
//                dao.updateQuantity(id, cartItem.getQuantity() + ProductService.getRemainQuantity(id)));
//    }
}
