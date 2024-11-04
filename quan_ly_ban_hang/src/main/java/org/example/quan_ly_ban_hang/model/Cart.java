package org.example.quan_ly_ban_hang.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<ProductNewDTO, Integer> productCart=new HashMap<ProductNewDTO, Integer>();
    public Map<ProductNewDTO, Integer> getProductCarts() {
        return productCart;
    }
    public  void addProduct(ProductNewDTO product, int quantity) {
        if(productCart.containsKey(product)) {
            productCart.put(product, productCart.get(product)+quantity);
        }else {
            productCart.put(product, quantity);
        }

    }
}
