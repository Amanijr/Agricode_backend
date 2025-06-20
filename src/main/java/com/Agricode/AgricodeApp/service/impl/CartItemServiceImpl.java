package com.Agricode.AgricodeApp.service.impl;

import com.Agricode.AgricodeApp.dto.CartItemDTO;
import com.Agricode.AgricodeApp.entity.CartItem;
import com.Agricode.AgricodeApp.repository.CartItemRepository;
import com.Agricode.AgricodeApp.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    private CartItemDTO mapToDTO(CartItem item) {
        CartItemDTO dto = new CartItemDTO();
        dto.setId(item.getId());
        dto.setProductId(item.getProduct() != null ? item.getProduct().getId() : null);
        dto.setProductName(item.getProduct() != null ? item.getProduct().getName() : null);
        dto.setPrice(item.getPrice());
        dto.setQuantity(item.getQuantity());
        dto.setProductImage(item.getProduct() != null ? item.getProduct().getImages() : null);
        return dto;
    }

    private CartItem mapToEntity(CartItemDTO dto) {
        CartItem item = new CartItem();
        item.setId(dto.getId());
        item.setPrice(dto.getPrice());
        item.setQuantity(dto.getQuantity());
        // Product and cart mapping should be handled in service if needed
        return item;
    }

    @Override
    public CartItemDTO getCartItemById(Long id) {
        return cartItemRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<CartItemDTO> getCartItemsByCartId(Long cartId) {
        return cartItemRepository.findByCartId(cartId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CartItemDTO> getCartItemsByProductId(Long productId) {
        return cartItemRepository.findByProductId(productId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CartItemDTO createCartItem(CartItemDTO cartItemDTO) {
        CartItem item = mapToEntity(cartItemDTO);
        return mapToDTO(cartItemRepository.save(item));
    }

    @Override
    public CartItemDTO updateCartItem(Long id, CartItemDTO cartItemDTO) {
        CartItem item = cartItemRepository.findById(id).orElseThrow();
        item.setPrice(cartItemDTO.getPrice());
        item.setQuantity(cartItemDTO.getQuantity());
        return mapToDTO(cartItemRepository.save(item));
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
} 