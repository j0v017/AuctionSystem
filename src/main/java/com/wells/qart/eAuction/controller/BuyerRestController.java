package com.wells.qart.eAuction.controller;

import com.wells.qart.eAuction.dto.BidDto;
import com.wells.qart.eAuction.exceptions.InvalidDataException;
import com.wells.qart.eAuction.service.BidService;
import com.wells.qart.eAuction.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/buyer")
public class BuyerRestController {

	@Autowired
	private BidService bidService;

	@Autowired
	private BuyerService buyerService;

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
