package com.wells.qart.eAuction.service;

import com.wells.qart.eAuction.dto.BidDto;
import com.wells.qart.eAuction.entity.Bid;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface BidService {	

	public BidDto placeBid(BidDto bidDto);
	public boolean updateBid(Long productId, String buyerEmailld, Double newBidAmount);
	public List<Bid> getAllBidsOnProductById(Long productId);

}
