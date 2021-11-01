package com.wells.qart.eAuction.controller;

import com.wells.qart.eAuction.dto.ProductDto;
import com.wells.qart.eAuction.entity.Bid;
import com.wells.qart.eAuction.exceptions.InvalidDataException;
import com.wells.qart.eAuction.service.BidService;
import com.wells.qart.eAuction.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerRestController {

	@Autowired
	ProductService productService;


	@Autowired
	BidService bidService;

	@PostMapping("/add-product")
	public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Product data is invalid");
		}
		productService.addProduct(productDto);
		return ResponseEntity.ok(productDto);
	}

	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable Long productId) {

			productService.deleteProduct(productId);

		return ResponseEntity.ok(true);
	}

	@GetMapping("/show-bids/{productId}")
	public ResponseEntity<List<Bid>> showBids(@PathVariable Long productId) {
		List<Bid> bidsList = bidService.getAllBidsOnProductById(productId);
		return ResponseEntity.ok(bidsList);
	}


	@GetMapping("/fetch-products")
	public ResponseEntity<List<ProductDto>> fetchProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}


}
