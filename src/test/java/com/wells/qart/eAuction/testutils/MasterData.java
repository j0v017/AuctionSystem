package com.wells.qart.eAuction.testutils;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wells.qart.eAuction.dto.*;
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
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
