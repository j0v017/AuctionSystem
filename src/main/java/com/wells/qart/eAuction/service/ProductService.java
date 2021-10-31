package com.wells.qart.eAuction.service;

import com.wells.qart.eAuction.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto);
    ProductDto getProductById(Long productId);
    List<ProductDto> getAllProducts();
    boolean deleteProduct(Long productId);


    ProductDto enlistBidsForProduct(ProductDto product);
    ProductDto putProductOnAuction(ProductDto product);
}
