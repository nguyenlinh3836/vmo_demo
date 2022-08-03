package com.example.vmo_demo.mapper;

import com.example.vmo_demo.model.request.ProductDto;
import com.example.vmo_demo.model.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDto, Product> {

}
