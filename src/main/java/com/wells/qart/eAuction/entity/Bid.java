package com.wells.qart.eAuction.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "bids")
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bidId;
	private Double bidAmount;
	private Long productId;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="fk_buyer_id",referencedColumnName="buyerId")
	private Buyer buyer;

}
