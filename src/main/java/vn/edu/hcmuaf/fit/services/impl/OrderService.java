package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.model.CartModel;
import vn.edu.hcmuaf.fit.services.IOrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OrderService implements IOrderService {
    @Override
    public boolean checkIdExistsInCart(String listId, HttpServletRequest request, HttpServletResponse response) {
        //Lay tat ca cac id mua hang
        StringTokenizer st = new StringTokenizer(listId,",");
        CartModel cart = (CartModel) request.getSession().getAttribute("cart");
        while(st.hasMoreTokens()) {
            if(!cart.getMap().containsKey(Integer.parseInt(st.nextToken()))) return true;
        }
        return false;
    }

    @Override
    public CartModel cartOrder(String list, HttpServletRequest request) {
        CartModel result = new CartModel();
        CartModel cart = (CartModel) request.getSession().getAttribute("cart");
        List<Integer> listId = getListId(list);
        for(int id : listId) {
            if(cart.getMap().containsKey(id)) {
                result.getMap().put(id, cart.getMap().get(id));
            }
        }

        return result;
    }

    public List<Integer> getListId(String list) {
        StringTokenizer st = new StringTokenizer(list,",");
        List<Integer> result = new ArrayList<>();
        while(st.hasMoreTokens()) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        return result;
    }

}