package com.wells.qart.eAuction.service;

import com.wells.qart.eAuction.dto.BidDto;
import com.wells.qart.eAuction.entity.Bid;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface BidService {	

	BidDto placeBid(BidDto bidDto);
	boolean updateBid(Long productId, String buyerEmailld, Double newBidAmount);
	List<Bid> getAllBidsOnProductById(Long productId);

}
