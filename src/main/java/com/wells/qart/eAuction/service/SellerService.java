package com.wells.qart.eAuction.service;

import com.wells.qart.eAuction.dto.SellerDto;

import java.util.List;

public interface SellerService {
	SellerDto addProduct(SellerDto product);

	SellerDto registerSeller(SellerDto sellerDto);

	SellerDto updateSeller(SellerDto sellerDto);

	Boolean deleteSeller(Long sellerId);

	SellerDto getSellerById(Long sellerId);

	List<SellerDto> getAllSellers();

}
