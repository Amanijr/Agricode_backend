package com.Agricode.AgricodeApp.service;

import com.Agricode.AgricodeApp.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    ProductDTO getProductById(Long id);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductsByCategory(String category);
    List<ProductDTO> getFeaturedProducts();
    List<ProductDTO> getOrganicProducts();
    List<ProductDTO> getProductsByFarmer(Long farmerId);
    List<ProductDTO> searchProductsByName(String name);
    List<ProductDTO> getProductsByLocation(String location);
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
} 