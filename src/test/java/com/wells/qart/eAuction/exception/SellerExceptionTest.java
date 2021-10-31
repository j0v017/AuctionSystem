package com.wells.qart.eAuction.exception;

import com.wells.qart.eAuction.controller.SellerRestController;
import com.wells.qart.eAuction.dto.ProductDto;
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
    private SellerService sellerService;
    @MockBean
    private ProductService productService;

    @AfterAll
    public static void afterAll() {
        testReport();
    }

    @Test
    public void testAddProductInvalidDataException() throws Exception {
        ProductDto productDto = MasterData.getProductDto();
        ProductDto savedProductDto = MasterData.getProductDto();
        savedProductDto.setProductId(1L);
        productDto.setProductName("abcdf");
        when(this.productService.addProduct(productDto)).thenReturn(savedProductDto);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add-product").content(MasterData.asJsonString(productDto))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        wellsAssert(currentTest(),
                (result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
                exceptionTestFile);
    }
    //@Test
    //public void testUpdateUserInvalidDataException() throws Exception {
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
//		wellsAssert(currentTest(),
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
//		wellsAssert(currentTest(),
//				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
//				exceptionTestFile);
//
//	}
//
}
