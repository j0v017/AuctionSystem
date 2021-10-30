package com.wells.qart.eAuction.exception;
import static com.wells.qart.eAuction.testutils.TestUtils.testReport;

import com.wells.qart.eAuction.service.SellerService;
import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
////import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.wells.qart.eAuction.controller.SellerRestController;

//import com.wells.qart.eAuction.testutils.MasterData;
@WebMvcTest(SellerRestController.class)
@AutoConfigureMockMvc
public class SellerExceptionTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private SellerService sellerService;
@AfterAll
public static void afterAll() {
	testReport();
}
//	@Test
//	public void testRegisterUserInvalidDataException() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		SellerDto savedSellerDto = MasterData.getUserDto();
//		savedSellerDto.setUserId(1L);
//
//		sellerDto.setName("ab");
//
//		when(this.sellerService.registerUser(sellerDto)).thenReturn(savedSellerDto);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users").content(MasterData.asJsonString(sellerDto))
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		yakshaAssert(currentTest(),
//				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
//				exceptionTestFile);
//
//	}
//
//	@Test
//	public void testUpdateUserInvalidDataException() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		SellerDto savedSellerDto = MasterData.getUserDto();
//		savedSellerDto.setUserId(1L);
//
//		sellerDto.setName("ab");
//		when(this.sellerService.updateUser(sellerDto)).thenReturn(savedSellerDto);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users").content(MasterData.asJsonString(sellerDto))
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		yakshaAssert(currentTest(),
//				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
//				exceptionTestFile);
//
//	}
//
//	@Test
//	public void testDeleteUserNotFoundException() throws Exception {
//		ExceptionResponse exResponse = new ExceptionResponse("Seller with Id - 2 not Found!", System.currentTimeMillis(),
//				HttpStatus.NOT_FOUND.value());
//
//		when(this.sellerService.deleteUser(2L)).thenThrow(new UserNotFoundException("Seller with Id - 2 not Found!"));
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/2")
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		yakshaAssert(currentTest(),
//				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
//				exceptionTestFile);
//
//	}
//
}
