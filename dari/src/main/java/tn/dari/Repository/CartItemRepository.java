package tn.dari.Repository;

import tn.dari.Model.cart.CartItem;
import tn.dari.Model.cart.CartItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository <CartItem, CartItemPK> {
}
