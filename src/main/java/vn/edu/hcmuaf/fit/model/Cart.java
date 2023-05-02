package vn.edu.hcmuaf.fit.model;

import vn.edu.hcmuaf.fit.dao.impl.ProductDAO;

import java.io.Serializable;
import java.util.*;

public class Cart implements Serializable {
    private final Map<Integer, CartItem> map = new HashMap<>();
    private int id;
    private int count;
    private double totalPrice;
    private int voucher = 0;
    private int ship = 0;
    private double totalPriceShip;
    private double totalPriceShipVoucher;
    private String timeShip;
    private int idUser;
    private List<Bill> bills;

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalPriceShip(double totalPriceShip) {
        this.totalPriceShip = totalPriceShip;
    }

    public void setTotalPriceShipVoucher(double totalPriceShipVoucher) {
        this.totalPriceShipVoucher = totalPriceShipVoucher;
    }

    public String getTimeShip() {
        return timeShip;
    }

    public void setTimeShip(String timeShip) {
        this.timeShip = timeShip;
    }

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

    public void deleteProductById(int id) {
        map.remove(id);
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

    public double getTotalPriceShip() {
        return getTotalPrice() + ship;
    }

    public double getTotalPriceShipVoucher() {
        return getTotalPriceShip() - voucher;
    }
    public int getVoucher() {
        return voucher;
    }

    public void setVoucher(int voucher) {
        this.voucher = voucher;
    }

    public int getShip() {
        return ship;
    }

    public void setShip(int ship) {
        this.ship = ship;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
