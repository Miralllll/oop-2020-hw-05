package Javas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* simple class for saving products for current user */
public class ShoppingCart {

    // productId, number of product
    private Map<String, Long> spCart;
    // i could save string and product too

    public ShoppingCart(){
        spCart = new HashMap<>();
    }

    /* increases the number of products in the cart with amount */
    public void addProduct(String productId, long amount){
        if(!spCart.containsKey(productId)) spCart.put(productId, Long.valueOf(0));
        spCart.put(productId, spCart.get(productId) + amount);
    }

    /* returns the number of products in the cart */
    public long getAmount(String productId){
        if(spCart.containsKey(productId))
            return spCart.get(productId);
        return 0;
    }

    /* returns the keyset of product */
    public Set<String> getProducts(){
        return spCart.keySet();
    }

    public static final String NAME = "ShoppingCart";
}
