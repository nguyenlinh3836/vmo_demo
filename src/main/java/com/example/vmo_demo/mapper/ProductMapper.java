package com.example.vmo_demo.mapper;

import com.example.vmo_demo.dto.ProductDto;
import com.example.vmo_demo.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDto, Product> {

}
