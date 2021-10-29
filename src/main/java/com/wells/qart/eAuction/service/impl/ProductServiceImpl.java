package com.wells.qart.eAuction.service.impl;

import com.wells.qart.eAuction.dto.ProductDto;
import com.wells.qart.eAuction.entity.Product;
import com.wells.qart.eAuction.exceptions.CannotDeleteProductException;
import com.wells.qart.eAuction.exceptions.ProductNotFoundException;
import com.wells.qart.eAuction.repository.ProductRepository;
import com.wells.qart.eAuction.repository.SellerRepository;
import com.wells.qart.eAuction.service.BidService;
import com.wells.qart.eAuction.service.ProductService;
import com.wells.qart.eAuction.utils.Utilities;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    BidService bidService;

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        Product prod =  productRepository.save(product);
        productDto.setProductId(prod.getProductId());
        return productDto;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        ProductDto productById = getProductById(productId);

        int bidsOnProduct = bidService.getAllBidsOnProductById(productId).size();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.now()));
        System.out.println("Current date"+date);
        System.out.println("Bid End date"+productById.getBidEndDate());
        LocalDate currentdate = LocalDate.parse(date);
        int currentDateShouldBeLessThanBidEndDate = Utilities.compareDates(currentdate, productById.getBidEndDate());
        System.out.println("Compare Dates "+currentDateShouldBeLessThanBidEndDate);

        if (currentDateShouldBeLessThanBidEndDate>0) {
            throw new CannotDeleteProductException("Cannot Delete Product after bid end date");
        } else if (bidsOnProduct>0){
            throw new CannotDeleteProductException("Cannot Delete Product with active bids");
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productById, product);
            productRepository.delete(product);
            return true;
        }
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Optional<Product> findById = productRepository.findById(productId);
        if (findById.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(findById.get(), productDto);
            return productDto;
        } else {
            throw new ProductNotFoundException("Product with id " + productId + " does not exists");
        }
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        if (allProducts.size()>0) {
            for (Product p : allProducts) {
                ProductDto pDto =new ProductDto();
                BeanUtils.copyProperties(p, pDto);
                productDtos.add(pDto);
            }
        }
        return productDtos;
    }
    @Override
    public ProductDto enlistBidsForProduct(ProductDto product) {
        return null;
    }

    @Override
    public ProductDto putProductOnAuction(ProductDto product) {
        return null;
    }
}
