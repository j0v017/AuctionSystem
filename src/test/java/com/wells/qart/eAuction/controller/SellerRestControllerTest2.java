package com.wells.qart.eAuction.controller;

import com.wells.qart.eAuction.dto.ProductDto;
import com.wells.qart.eAuction.dto.SellerDto;
import com.wells.qart.eAuction.entity.Bid;
import com.wells.qart.eAuction.entity.Buyer;
import com.wells.qart.eAuction.service.BidService;
import com.wells.qart.eAuction.service.ProductService;
import com.wells.qart.eAuction.service.SellerService;
import com.wells.qart.eAuction.testutils.MasterData;
//import com.wells.qart.eAuction.testutils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;
//import com.fasterxml.jackson.*;

import static com.wells.qart.eAuction.testutils.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SellerRestController.class)
class SellerRestControllerTest2 {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SellerService mockSellerService;
    @MockBean
    private ProductService productService;
    @MockBean
    private BidService mockBidService;

    @Test
    void testAddProduct() throws Exception {
        // Setup
//        SellerDto sellerDto= MasterData.getSellerDto();
//        SellerDto savedSellerDto=MasterData.getSellerDto();
//        savedSellerDto.setSellerId(1L);

        ProductDto productDto=MasterData.getProductDto();
        ProductDto savedProductDto=MasterData.getProductDto();
        savedProductDto.setProductId(1L);


        // Configure ProductService.addProduct(...).
        //final ProductDto productDto = new ProductDto(1L, "productName", new BigDecimal("0.00"), "shortDescription", "detailedDescription", LocalDate.of(2020, 1, 1), "category");
        when(this.productService.addProduct(productDto)).thenReturn(savedProductDto);
        RequestBuilder requestBuilder= MockMvcRequestBuilders.post("/seller/add-product").content(MasterData.asJsonString(productDto))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        MvcResult result=mockMvc.perform(requestBuilder).andReturn();


        // Run the test
        wellsAssert(currentTest(),
                (result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedProductDto))?"true":"false"),
                businessTestFile);
    }

    @Test
    void testDeleteProduct() throws Exception {
        // Setup
        when(productService.deleteProduct(2L)).thenReturn(false);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/seller/delete/{productId}", 2)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("true");
        verify(productService).deleteProduct(2L);
    }

    @Test
    void testShowBids() throws Exception {
        // Setup

        // Configure BidService.getAllBidsOnProductById(...).
        final List<Bid> bids = List.of(new Bid(1L, 9999.0, 2L, new Buyer(1L, "firstName", "lastName", 0L, 0L, "address", "email", "city", "state", Set.of())));
        when(mockBidService.getAllBidsOnProductById(0L)).thenReturn(bids);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/seller/show-bids/{productId}", 2)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testShowBids_BidServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockBidService.getAllBidsOnProductById(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/seller/show-bids/{productId}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testFetchProducts() throws Exception {
        // Setup

        // Configure ProductService.getAllProducts(...).
        final List<ProductDto> productDtos = List.of(new ProductDto(0L, "productName", new BigDecimal("0.00"), "shortDescription", "detailedDescription", LocalDate.of(2020, 1, 1), "category"));
        when(productService.getAllProducts()).thenReturn(productDtos);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/seller/fetch-products")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testFetchProducts_ProductServiceReturnsNoItems() throws Exception {
        // Setup
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/seller/fetch-products")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
