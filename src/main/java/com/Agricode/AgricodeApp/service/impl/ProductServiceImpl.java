package com.Agricode.AgricodeApp.service.impl;

import com.Agricode.AgricodeApp.dto.ProductDTO;
import com.Agricode.AgricodeApp.entity.Product;
import com.Agricode.AgricodeApp.repository.ProductRepository;
import com.Agricode.AgricodeApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ProductDTO mapToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCategory(product.getCategory());
        dto.setStock(product.getStock());
        dto.setUnit(product.getUnit());
        dto.setLocation(product.getLocation());
        dto.setOrganic(product.isOrganic());
        dto.setFeatured(product.isFeatured());
        dto.setHarvestDate(product.getHarvestDate());
        dto.setExpiryDate(product.getExpiryDate());
        dto.setRating(product.getRating());
        dto.setImages(product.getImages());
        if (product.getFarmer() != null) {
            dto.setFarmerId(product.getFarmer().getId());
            dto.setFarmerName(product.getFarmer().getName());
        }
        return dto;
    }

    private Product mapToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        product.setStock(dto.getStock());
        product.setUnit(dto.getUnit());
        product.setLocation(dto.getLocation());
        product.setOrganic(dto.isOrganic());
        product.setFeatured(dto.isFeatured());
        product.setHarvestDate(dto.getHarvestDate());
        product.setExpiryDate(dto.getExpiryDate());
        product.setRating(dto.getRating());
        product.setImages(dto.getImages());
        // Farmer mapping should be handled in service if needed
        return product;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) {
        return productRepository.findByCategory(category).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getFeaturedProducts() {
        return productRepository.findByFeaturedTrue().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getOrganicProducts() {
        return productRepository.findByIsOrganicTrue().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByFarmer(Long farmerId) {
        return productRepository.findByFarmerId(farmerId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByLocation(String location) {
        return productRepository.findByLocation(location).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = mapToEntity(productDTO);
        return mapToDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow();
        // Update fields
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setStock(productDTO.getStock());
        product.setUnit(productDTO.getUnit());
        product.setLocation(productDTO.getLocation());
        product.setOrganic(productDTO.isOrganic());
        product.setFeatured(productDTO.isFeatured());
        product.setHarvestDate(productDTO.getHarvestDate());
        product.setExpiryDate(productDTO.getExpiryDate());
        product.setRating(productDTO.getRating());
        product.setImages(productDTO.getImages());
        return mapToDTO(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
} 