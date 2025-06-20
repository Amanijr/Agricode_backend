package com.Agricode.AgricodeApp.service;

import com.Agricode.AgricodeApp.dto.CartItemDTO;
import java.util.List;

public interface CartItemService {
    CartItemDTO getCartItemById(Long id);
    List<CartItemDTO> getCartItemsByCartId(Long cartId);
    List<CartItemDTO> getCartItemsByProductId(Long productId);
    CartItemDTO createCartItem(CartItemDTO cartItemDTO);
    CartItemDTO updateCartItem(Long id, CartItemDTO cartItemDTO);
    void deleteCartItem(Long id);
} 