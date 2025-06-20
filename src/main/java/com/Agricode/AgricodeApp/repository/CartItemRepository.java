package com.Agricode.AgricodeApp.repository;

import com.Agricode.AgricodeApp.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCartId(Long cartId);
    List<CartItem> findByProductId(Long productId);
} 