package com.Agricode.AgricodeApp.service;

import com.Agricode.AgricodeApp.dto.CartDTO;
import java.util.Optional;

public interface CartService {
    CartDTO getCartById(Long id);
    Optional<CartDTO> getCartByUserId(Long userId);
    CartDTO createCart(CartDTO cartDTO);
    CartDTO updateCart(Long id, CartDTO cartDTO);
    void deleteCart(Long id);
} 