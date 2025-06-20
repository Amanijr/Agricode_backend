package com.Agricode.AgricodeApp.repository;

import com.Agricode.AgricodeApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findByFeaturedTrue();
    List<Product> findByIsOrganicTrue();
    List<Product> findByFarmerId(Long farmerId);
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByLocation(String location);
} 