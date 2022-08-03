package com.example.vmo_demo.service;

import com.example.vmo_demo.model.request.ProductDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface ProductService {
  List<ProductDto> listAllProduct(int offset, int pageSize);

  ProductDto getProductById(long id);

  ProductDto insertProduct(ProductDto productDto);

  ProductDto updateProduct(ProductDto productDto, long id);

  void delete(long id);

  List<ProductDto> getProductByName(String name, Pageable pageable);

}
