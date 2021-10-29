package com.wells.qart.eAuction.controller;

import com.wells.qart.eAuction.dto.ProductDto;
import com.wells.qart.eAuction.entity.Bid;
import com.wells.qart.eAuction.exceptions.InvalidDataException;
import com.wells.qart.eAuction.service.BidService;
import com.wells.qart.eAuction.service.ProductService;
import com.wells.qart.eAuction.service.SellerService;
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
	private SellerService sellerService;

	@Autowired
	ProductService productService;


	//@Autowired
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


//	@GetMapping("/users")
//	public ResponseEntity<?> getUsers() {
//
//		List<SellerDto> list = sellerService.findAll();
//		if (list.size() != 0) {
//			return new ResponseEntity<List<SellerDto>>(list, HttpStatus.OK);
//
//		} else {
//			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@GetMapping("/users/{userId}")
//	public ResponseEntity<?> getUserById(@PathVariable("userId") Long userId) {
//
//		SellerDto sellerDto = sellerService.getById(userId);
//
//		return ResponseEntity.ok(sellerDto);
//
//	}
//
//	@PostMapping(path ="/users" ,consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> saveUser(@Valid @RequestBody SellerDto sellerDto, BindingResult result) {
//
//		if (result.hasErrors()) {
//			throw new InvalidDataException("Invalid Seller Data");
//		}
//		sellerService.registerUser(sellerDto);
//		return new ResponseEntity<SellerDto>(sellerDto, HttpStatus.OK);
//
//	}

//	@DeleteMapping("/users/{userId}")
//	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
//		sellerService.deleteUser(userId);
//		return new ResponseEntity<>(true, HttpStatus.OK);
//	}

//	@PutMapping(path = "/users",consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> updateUser(@Valid @RequestBody SellerDto sellerDto, BindingResult result) {
//
//		if (result.hasErrors()) {
//			throw new InvalidDataException("Invalid Seller Data");
//		}
//		sellerService.updateUser(sellerDto);
//		return new ResponseEntity<SellerDto>(sellerDto, HttpStatus.OK);
//
//	}
}
