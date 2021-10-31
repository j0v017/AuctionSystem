package com.wells.qart.eAuction.exception;

import com.wells.qart.eAuction.controller.BuyerRestController;
import com.wells.qart.eAuction.dto.BidDto;
import com.wells.qart.eAuction.service.BidService;
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
public class BuyerExceptionTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BidService bidService;

    @AfterAll
    public static void afterAll() {
        testReport();
    }

    @Test
    public void testBuyerInvalidDataException() throws Exception {
        BidDto bidDto = MasterData.getBidDto();
        BidDto savedbidDto = MasterData.getBidDto();
        savedbidDto.setId(1L);

        bidDto.setId(1L);

        when(this.bidService.placeBid(bidDto)).thenReturn(savedbidDto);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bids").content(MasterData.asJsonString(bidDto))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        wellsAssert(currentTest(),
                (result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
                exceptionTestFile);

    }

//	@Test
//	public void testUpdatebidInvalidDataException() throws Exception {
//		bidDto bidDto = MasterData.getbidDto();
//		bidDto savedbidDto = MasterData.getbidDto();
//		savedbidDto.setbidId(1L);
//
//		bidDto.setName("ab");
//		when(this.bidService.updatebid(bidDto)).thenReturn(savedbidDto);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/bids").content(MasterData.asJsonString(bidDto))
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		wellsAssert(currentTest(),
//				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
//				exceptionTestFile);
//
//	}
//
//	@Test
//	public void testDeletebidNotFoundException() throws Exception {
//		ExceptionResponse exResponse = new ExceptionResponse("bid with Id - 2 not Found!", System.currentTimeMillis(),
//				HttpStatus.NOT_FOUND.value());
//
//		when(this.bidService.deleteBid(2L)).thenThrow(new bidNotFoundException("bid with Id - 2 not Found!"));
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/bids/2")
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		wellsAssert(currentTest(),
//				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
//				exceptionTestFile);
//
//	}

}
