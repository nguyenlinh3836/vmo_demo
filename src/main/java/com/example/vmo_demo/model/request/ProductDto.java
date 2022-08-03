package com.example.vmo_demo.model.request;

import javax.persistence.Id;

public class ProductDto {
  @Id
  private int id;
  private String productName;
  private double price;

  public ProductDto() {
  }

  public ProductDto(int id, String productName, double price) {
    this.id = id;
    this.productName = productName;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
