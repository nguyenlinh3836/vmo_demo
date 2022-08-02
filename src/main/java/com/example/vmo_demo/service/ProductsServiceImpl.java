package com.example.vmo_demo.service;

import com.example.vmo_demo.dto.ProductDto;
import com.example.vmo_demo.mapper.ProductMapper;
import com.example.vmo_demo.model.Product;
import com.example.vmo_demo.repository.ProductRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ProductsServiceImpl implements ProductService {
  @Autowired
  private ProductRepo productRepo;

  @Autowired
  private ProductMapper productMapper;


  @Override
  @Transactional
  public List<ProductDto> listAllProduct(int offset, int pageSize) {
    Page<Product> products = productRepo.findAll(PageRequest.of(offset,pageSize));
    List<ProductDto> dtos = productMapper.toDtoList(products.getContent());
    return dtos;
  }

  @Override
  @Transactional
  public ProductDto getProductById(long id) {
    return productMapper.toDto(productRepo.getById(id));
  }

  @Override
  @Transactional
  public ProductDto insertProduct(ProductDto productDto) {
    Product product = productMapper.toEntity(productDto);
    return productMapper.toDto(productRepo.save(product));
  }

  @Override
  @Transactional
  public ProductDto updateProduct(ProductDto productDto, long id) {
    Product product = productMapper.toEntity(productDto);
    product.setId(id);
    return productMapper.toDto(productRepo.save(product));
  }

  @Override
  @Transactional
  public void delete(long id) {
    Product product = productRepo.getById(id);
    productRepo.delete(product);
  }

  @Override
  public List<ProductDto> getProductByName(String name, Pageable pageable) {
    return productMapper.toDtoList(productRepo.getProductByProductName(name, pageable));
  }

}
