package com.wells.qart.eAuction.service;

import com.wells.qart.eAuction.dto.BuyerDto;

public interface BuyerService {

	BuyerDto addBuyer(BuyerDto buyerDto);
	BuyerDto bidForProduct(Long productId);
	BuyerDto updateBidAmt(Long productId);



}
