package com.example.vmo_demo.controller;

import com.example.vmo_demo.model.request.ProductDto;
import com.example.vmo_demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

  private ProductService productService;

  @GetMapping
  public ResponseEntity<?> listProduct(@RequestParam(name = "page") int page,
      @RequestParam(name = "size") int size) {
    return ResponseEntity.ok(productService.listAllProduct(page, size));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<?> getProductById(@PathVariable int id) {
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.getProductById(id));
  }

  @PostMapping
  public ResponseEntity<?> insertProduct(@RequestBody ProductDto productDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(productService.insertProduct(productDto));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto, @PathVariable int id) {
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(productService.updateProduct(productDto, id));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable int id) {
    productService.delete(id);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product has been delete");
  }

}
