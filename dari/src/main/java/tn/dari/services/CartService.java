package tn.dari.services;

import java.util.List;


import org.springframework.stereotype.Service;
import tn.dari.entities.AddtoCart;
import tn.dari.entities.CheckoutCart;


@Service
public interface CartService {
    List<AddtoCart> addCartbyUserIdAndFurnitureId(long furnitureId, long userId, int qty, double price) throws Exception;
    void updateQtyByCartId(long cartId,int qty,double price) throws Exception;

    List<AddtoCart> getCartByUserId(long userId);
    List<AddtoCart> removeCartByUserId(long cartId,long userId);
    List<AddtoCart> removeAllCartByUserId(long userId);
    Boolean checkTotalAmountAgainstCart(double totalAmount,long userId);
    List<CheckoutCart> getAllCheckoutByUserId(long userId);
    List<CheckoutCart> saveFurnitureForCheckout(List<CheckoutCart> tmp)  throws Exception;

}