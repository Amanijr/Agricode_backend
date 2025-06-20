package com.Agricode.AgricodeApp.service.impl;

import com.Agricode.AgricodeApp.dto.CartDTO;
import com.Agricode.AgricodeApp.dto.CartItemDTO;
import com.Agricode.AgricodeApp.entity.Cart;
import com.Agricode.AgricodeApp.entity.CartItem;
import com.Agricode.AgricodeApp.repository.CartRepository;
import com.Agricode.AgricodeApp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    private CartDTO mapToDTO(Cart cart) {
        CartDTO dto = new CartDTO();
        dto.setId(cart.getId());
        dto.setUserId(cart.getUser() != null ? cart.getUser().getId() : null);
        if (cart.getItems() != null) {
            dto.setItems(cart.getItems().stream().map(this::mapItemToDTO).collect(Collectors.toList()));
        }
        dto.setTotalPrice(cart.getTotalPrice());
        dto.setTotalItems(cart.getTotalItems());
        return dto;
    }

    private CartItemDTO mapItemToDTO(CartItem item) {
        CartItemDTO dto = new CartItemDTO();
        dto.setId(item.getId());
        dto.setProductId(item.getProduct() != null ? item.getProduct().getId() : null);
        dto.setProductName(item.getProduct() != null ? item.getProduct().getName() : null);
        dto.setPrice(item.getPrice());
        dto.setQuantity(item.getQuantity());
        dto.setProductImage(item.getProduct() != null ? item.getProduct().getImages() : null);
        return dto;
    }

    private Cart mapToEntity(CartDTO dto) {
        Cart cart = new Cart();
        cart.setId(dto.getId());
        cart.setTotalPrice(dto.getTotalPrice());
        cart.setTotalItems(dto.getTotalItems());
        // User and items mapping should be handled in service if needed
        return cart;
    }

    @Override
    public CartDTO getCartById(Long id) {
        return cartRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public Optional<CartDTO> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId).map(this::mapToDTO);
    }

    @Override
    public CartDTO createCart(CartDTO cartDTO) {
        Cart cart = mapToEntity(cartDTO);
        return mapToDTO(cartRepository.save(cart));
    }

    @Override
    public CartDTO updateCart(Long id, CartDTO cartDTO) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        cart.setTotalPrice(cartDTO.getTotalPrice());
        cart.setTotalItems(cartDTO.getTotalItems());
        return mapToDTO(cartRepository.save(cart));
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
} 