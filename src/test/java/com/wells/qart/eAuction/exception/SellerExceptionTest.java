package com.wells.qart.eAuction.exception;//package com.wells.qart.eAuction.exception;

import com.wells.qart.eAuction.controller.SellerRestController;
import com.wells.qart.eAuction.dto.ProductDto;
import com.wells.qart.eAuction.dto.SellerDto;
import com.wells.qart.eAuction.exception.response.ExceptionResponse;
import com.wells.qart.eAuction.exceptions.ProductNotFoundException;
import com.wells.qart.eAuction.exceptions.SellerNotFoundException;
import com.wells.qart.eAuction.service.BidService;
import com.wells.qart.eAuction.service.ProductService;
import com.wells.qart.eAuction.service.SellerService;
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

@WebMvcTest(SellerRestController.class)
@AutoConfigureMockMvc
public class SellerExceptionTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BidService bidsService;

	@MockBean
	private SellerService sellerService;

	@MockBean
	private ProductService productService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testInvalidDataException() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		SellerDto savedSellerDto = MasterData.getSellerDto();

		savedSellerDto.setSellerId(1L);
		sellerDto.setFirstName("Ab");
		ProductDto productDto=MasterData.getProductDto();
		ProductDto savedProductDto=MasterData.getProductDto();

		when(this.productService.addProduct(productDto)).thenReturn(savedProductDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/seller/add-product")
				.content(MasterData.asJsonString(sellerDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		wellsAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);
    }

	@Test
	public void testSellerNotFoundException() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse("Product with Id - 1 not Found!", System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value());

		when(this.productService.getProductById(1L)).thenThrow(new ProductNotFoundException("Seller not found"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/get/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		wellsAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);
	}
}
