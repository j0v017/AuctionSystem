package com.wells.qart.eAuction.service;

import com.wells.qart.eAuction.dto.SellerDto;

import java.util.List;

public interface SellerService {
	public SellerDto addProduct(SellerDto product);

	public SellerDto registerSeller(SellerDto sellerDto);

	public SellerDto updateSeller(SellerDto sellerDto);

	public Boolean deleteSeller(Long sellerId);

	public SellerDto getSellerById(Long sellerId);

	public List<SellerDto> getAllSellers();

}
