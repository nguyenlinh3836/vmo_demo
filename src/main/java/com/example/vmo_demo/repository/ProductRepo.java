package com.example.vmo_demo.repository;

import com.example.vmo_demo.model.entities.Product;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
  List<Product> getProductByProductName(String name, Pageable pageable);
}
