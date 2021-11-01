package com.wells.qart.eAuction.testutils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wells.qart.eAuction.dto.BidDto;
import com.wells.qart.eAuction.dto.BuyerDto;
import com.wells.qart.eAuction.dto.ProductDto;
import com.wells.qart.eAuction.dto.SellerDto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MasterData {
	public static SellerDto getSellerDto() {
		SellerDto seller = new SellerDto();
		seller.setSellerId(1L);
		seller.setFirstName("Name");
		seller.setEmail("name@mail.com");
		seller.setPin(222222);
		seller.setPhoneNumber(1234567890L);
		seller.setCity("Mumbai");
		seller.setState("AP");
		return seller;
	}

	public static ProductDto getProductDto() {
		ProductDto product = new ProductDto();
		product.setProductId(1L);
		product.setProductName("Name");
		product.setBidEndDate(LocalDate.of(2022, 1, 1));
		product.setCategory("ornament");
		product.setShortDescription("short");
		product.setDetailedDescription("detailed textual definition");
		product.setStartingPrice(new BigDecimal("1025.25"));
		return product;
	}

	public static BuyerDto getBuyerDto() {
		BuyerDto buyer = new BuyerDto();
		buyer.setBuyerId(1L);
		buyer.setEmail("email@gmail.com");
		buyer.setFirstName("first");
		buyer.setLastName("last");
		buyer.setAddress("address");
		buyer.setCity("Patna");
		buyer.setState("Bihar");
		buyer.setPhoneNumber(1234567890L);
		buyer.setPin(888888L);
		return buyer;
	}

	public static BidDto getBidDto() {
		BidDto bid = new BidDto();
		bid.setBidAmount(9999.99);
		bid.setProductId(1L);
		bid.setId(1L);
		return bid;
	}

	public static List<ProductDto> getProductDtoList() {
		List<ProductDto> products = new ArrayList<>();
		ProductDto product = new ProductDto();
		product.setProductId(1L);
		product.setProductName("Rajesh");
		product.setCategory("ornament");
		product.setShortDescription("short");
		product.setDetailedDescription("details are here");
		product.setStartingPrice(new BigDecimal("9999.99"));
		product.setBidEndDate(LocalDate.of(2022, 1, 1));
		products.add(product);
		product=new ProductDto();
		product.setProductId(2L);
		product.setProductName("Ratnesh");
		product.setCategory("ornament");
		product.setShortDescription("short2");
		product.setDetailedDescription("details are here too");
		product.setStartingPrice(new BigDecimal("999.99"));
		product.setBidEndDate(LocalDate.of(2023, 1, 1));
		products.add(product);
		return products;
	}
	public static List<BidDto> getBidDtoList(){
		List<BidDto> bids=new ArrayList<>();
		BidDto bid=new BidDto();
		bid.setId(1L);
		bid.setBidAmount(999.99);
		bid.setProductId(1L);
		bids.add(bid);
		bid=new BidDto();
		bid.setId(2L);
		bid.setBidAmount(99.99);
		bid.setProductId(2L);
		bids.add(bid);
		return bids;
	}
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			mapper.setDateFormat(df);
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
