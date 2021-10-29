package com.wells.qart.eAuction.repository;

import com.wells.qart.eAuction.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {	

  List<Bid> getBidsByProductId(Long productId);
  List<Bid> findByProductIdAndBuyerEmail(Long productId,String email);
  List<Bid> findByProductIdOrderByBidAmountDesc(Long productId);
}
