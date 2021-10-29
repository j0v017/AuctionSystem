package com.wells.qart.eAuction.service.impl;

import com.wells.qart.eAuction.dto.BidDto;
import com.wells.qart.eAuction.entity.Bid;
import com.wells.qart.eAuction.entity.Product;
import com.wells.qart.eAuction.exceptions.CannotDeleteProductException;
import com.wells.qart.eAuction.exceptions.DuplicateBidException;
import com.wells.qart.eAuction.exceptions.InvalidDataException;
import com.wells.qart.eAuction.exceptions.ProductNotFoundException;
import com.wells.qart.eAuction.repository.BidRepository;
import com.wells.qart.eAuction.repository.ProductRepository;
import com.wells.qart.eAuction.service.BidService;
import com.wells.qart.eAuction.utils.Utilities;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BidServiceImpl implements BidService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BidRepository bidRepository;

	@Override
	public BidDto placeBid(BidDto bidDto) {
		Long productId =bidDto.getProductId();
		Optional<Product> product = productRepository.findById(productId);
		List<Bid> bidsList = bidRepository.getBidsByProductId(productId);
		String bidEmail = bidDto.getBuyer().getEmail();
		for (Bid b: bidsList) {
			if (b.getBuyer().getEmail().contains(bidEmail)) {
				throw new DuplicateBidException("Email "+bidEmail+" has an active bid for Product Id "+productId+".Cannot place bid.");
			}
		}
		if (!product.isPresent()) {
			throw new ProductNotFoundException("Product ID "+bidDto.getProductId()+" is not found");
		} else {
			LocalDate bidEndDate = product.get().getBidEndDate();
			String date = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.now()));
			LocalDate currentDate = LocalDate.parse(date);
			int currentDateShouldBeLessThanBidEndDate = Utilities.compareDates(currentDate, bidEndDate);
			if (currentDateShouldBeLessThanBidEndDate>0) {
				throw new CannotDeleteProductException("Cannot bid for Product after bid end date");
			}		
			Bid bid = new Bid();
			BeanUtils.copyProperties(bidDto, bid);
			bid.getBuyer().setBuyerId(null);
			Bid bidSaved = bidRepository.save(bid);
			
			bidDto.setId(bidSaved.getBidId());
			return bidDto;
		}
	}

	@Override
	public List<Bid> getAllBidsOnProductById(Long productId) {	
		return bidRepository.findByProductIdOrderByBidAmountDesc(productId);
	}

	@Override
	public boolean updateBid(Long productId, String buyerEmailld,Double newBidAmount){
		List<Bid> bids = bidRepository.findByProductIdAndBuyerEmail(productId,buyerEmailld);
		if(bids.isEmpty()){
			throw new InvalidDataException("No Bids for given email nd product id");
		}
		Bid bid = bids.get(0);
		bid.setBidAmount(newBidAmount);
		bidRepository.save(bid);
		return true;
	}
	
	

}
