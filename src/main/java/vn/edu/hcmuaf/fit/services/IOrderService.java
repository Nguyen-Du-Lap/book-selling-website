package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IOrderService {
    boolean checkIdExistsInCart(String listId, HttpServletRequest request, HttpServletResponse response);
    Cart cartOrder(String list, HttpServletRequest request);
}