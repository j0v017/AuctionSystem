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
		//LocalDate date= LocalDate.parse("2011-11-11");

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
		buyer.setCity("Muzaffarpur");
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
		//bid.setBuyer();
		return bid;
	}

	//public static List<SellerDto> getUserDtoList() {
//		List<SellerDto> users = new ArrayList<>();
//		SellerDto user = new SellerDto();
////		user.setUserId(1L);
////		user.setName("First");
////		user.setEmail("first@mail.com");
////		user.setAge(22);
////		user.setGender("Male");
////		user.setPhoneNumber(1234567890L);
////		user.setCity("Mumbai");
////		user.setCountry("India");
////		users.add(user);
////		user = new SellerDto();
////		user.setUserId(2L);
////		user.setName("Second");
////		user.setEmail("second@mail.com");
////		user.setAge(23);
////		user.setGender("Female");
////		user.setPhoneNumber(99994567890L);
////		user.setCity("London");
////		user.setCountry("England");
////		users.add(user);
//		return users;
//	}
//
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
