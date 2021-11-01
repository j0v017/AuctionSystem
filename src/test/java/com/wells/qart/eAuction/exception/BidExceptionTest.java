package com.wells.qart.eAuction.exception;

import com.wells.qart.eAuction.controller.BuyerRestController;
import com.wells.qart.eAuction.dto.BidDto;
import com.wells.qart.eAuction.dto.BuyerDto;
import com.wells.qart.eAuction.service.BidService;
import com.wells.qart.eAuction.service.BuyerService;
import com.wells.qart.eAuction.testutils.MasterData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.wells.qart.eAuction.testutils.TestUtils.*;
import static org.mockito.Mockito.when;

@WebMvcTest(BuyerRestController.class)
@AutoConfigureMockMvc
public class BidExceptionTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BidService bidService;
	
	@MockBean
	private BuyerService  buyerService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testInvalidDataException() throws Exception {
		BuyerDto customerDto = MasterData.getBuyerDto();
		BuyerDto savedCustomerDto = MasterData.getBuyerDto();

		savedCustomerDto.setBuyerId(1L);
		customerDto.setFirstName("Ab");

		when(this.buyerService.addBuyer(customerDto)).thenReturn(savedCustomerDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/buyer/place-bid")
				.content(MasterData.asJsonString(customerDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		wellsAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}
	@Test
	public void testUpdateBidInvalidDataException() throws Exception {
		BuyerDto customerDto = MasterData.getBuyerDto();
		BuyerDto savedCustomerDto = MasterData.getBuyerDto();

		savedCustomerDto.setBuyerId(1L);
		customerDto.setFirstName("Ab");

		BidDto bidDto=MasterData.getBidDto();
		BidDto savedBidDto=MasterData.getBidDto();
		bidDto.setId(1L);bidDto.setProductId(1L);
		savedBidDto.setBidAmount(111.1);


		when(this.buyerService.addBuyer(customerDto)).thenReturn(savedCustomerDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/update-bid/productId/emailId/newBidAmount")
				.content(MasterData.asJsonString(customerDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		wellsAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}
	@Test
	public void testDuplicateBidException() throws Exception {
		BuyerDto buyerDto = MasterData.getBuyerDto();
		BuyerDto savedBuyerDto = MasterData.getBuyerDto();

		savedBuyerDto.setEmail("email.gmail.com");
		buyerDto.setFirstName("Abcde");

		BidDto bidDto=MasterData.getBidDto();
		BidDto savedBidDto=MasterData.getBidDto();
		bidDto.setId(1L);

		when(this.buyerService.addBuyer(buyerDto)).thenReturn(savedBuyerDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/buyer/place-bid")
				.content(MasterData.asJsonString(buyerDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		wellsAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}

}
