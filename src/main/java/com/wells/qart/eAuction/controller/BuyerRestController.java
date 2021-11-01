package com.wells.qart.eAuction.controller;

import com.wells.qart.eAuction.dto.BidDto;
import com.wells.qart.eAuction.exceptions.InvalidDataException;
import com.wells.qart.eAuction.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/buyer")
public class BuyerRestController {

	@Autowired
	private BidService bidService;


	@PostMapping("/place-bid")
	public ResponseEntity<BidDto> addBid(@Valid @RequestBody BidDto bidDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Bid data is not Valid!");
		}
		bidService.placeBid(bidDto);
		return ResponseEntity.ok(bidDto);
	}

	@PutMapping("/update-bid/{productId}/{buyerEmailld}/{newBidAmount}")
	public ResponseEntity<Boolean> updateBid(@PathVariable Long productId, @PathVariable String buyerEmailld,
											 @PathVariable Double newBidAmount) {

		boolean ret = bidService.updateBid(productId,buyerEmailld,newBidAmount);
		return ResponseEntity.ok(ret);
	}
}
