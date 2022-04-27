package tn.dari.controllers;

import java.util.HashMap;
import java.util.List;


import jwtconf.ShoppingConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.dari.entities.AddtoCart;
import tn.dari.services.CartService;


@RestController
@RequestMapping("api/addtocart")
public class AddtoCartController {

    @Autowired
    CartService cartService;
    @RequestMapping("addFurniture")
    public ResponseEntity<?> addCartwithFurniture(@RequestBody HashMap<String,String> addCartRequest) {
        try {
            String keys[] = {"furnitureId","userId","qty","price"};
            if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {

            }
            long furnitureId = Long.parseLong(addCartRequest.get("furnitureId"));
            long userId =  Long.parseLong(addCartRequest.get("userId"));
            int qty =  Integer.parseInt(addCartRequest.get("qty"));
            double price = Double.parseDouble(addCartRequest.get("price"));
            List<AddtoCart> obj = cartService.addCartbyUserIdAndFurnitureId(furnitureId,userId,qty,price);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }

    }

    @RequestMapping("updateQtyForCart")
    public ResponseEntity<?> updateQtyForCart(@RequestBody HashMap<String,String> addCartRequest) {
        try {
            String keys[] = {"cartId","userId","qty","price"};
            if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {

            }
            long cartId = Long.parseLong(addCartRequest.get("cartId"));
            long userId =  Long.parseLong(addCartRequest.get("userId"));
            int qty =  Integer.parseInt(addCartRequest.get("qty"));
            double price = Double.parseDouble(addCartRequest.get("price"));
            cartService.updateQtyByCartId(cartId, qty, price);
            List<AddtoCart> obj = cartService.getCartByUserId(userId);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }

    }


    @RequestMapping("removeFurnitureFromCart")
    public ResponseEntity<?> removeCartwithFurnitureId(@RequestBody HashMap<String,String> removeCartRequest) {
        try {
            String keys[] = {"userId","cartId"};
            if(ShoppingConfiguration.validationWithHashMap(keys, removeCartRequest)) {

            }
            List<AddtoCart> obj = cartService.removeCartByUserId(Long.parseLong(removeCartRequest.get("cartId")), Long.parseLong(removeCartRequest.get("userId")));
            return ResponseEntity.ok(obj);
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }

    @RequestMapping("getCartsByUserId")
    public ResponseEntity<?> getCartsByUserId(@RequestBody HashMap<String,String> getCartRequest) {
        try {
            String keys[] = {"userId"};
            if(ShoppingConfiguration.validationWithHashMap(keys, getCartRequest)) {
            }
            List<AddtoCart> obj = cartService.getCartByUserId(Long.parseLong(getCartRequest.get("userId")));
            return ResponseEntity.ok(obj);
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }
}