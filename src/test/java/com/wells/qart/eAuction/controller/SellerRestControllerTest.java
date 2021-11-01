package com.wells.qart.eAuction.controller;

import com.wells.qart.eAuction.dto.ProductDto;
import com.wells.qart.eAuction.entity.Bid;
import com.wells.qart.eAuction.entity.Buyer;
import com.wells.qart.eAuction.service.BidService;
import com.wells.qart.eAuction.service.ProductService;
import com.wells.qart.eAuction.service.SellerService;
import com.wells.qart.eAuction.testutils.MasterData;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SellerRestController.class)
class SellerRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SellerService mockSellerService;
    @MockBean
    private ProductService mockProductService;
    @MockBean
    private BidService mockBidService;

    @Test
    void testAddProduct() throws Exception {
        // Setup

        // Configure ProductService.addProduct(...).
        final ProductDto productDto = new ProductDto(4L, "produ", new BigDecimal("99999"), "short", "detailedDescription", LocalDate.of(2021, 11, 20), "ornament");
        when(mockProductService.addProduct(new ProductDto(4L, "produ", new BigDecimal("99999"), "short", "detailedDescription", LocalDate.of(2021, 11, 20), "ornament"))).thenReturn(productDto);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/seller/add-product")
                        .content(MasterData.asJsonString(productDto)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(MasterData.asJsonString(productDto));
        verify(mockProductService).addProduct(new ProductDto(4L, "produ", new BigDecimal("99999"), "short", "detailedDescription", LocalDate.of(2021, 11, 20), "ornament"));
    }

    @Test
    void testDeleteProduct() throws Exception {
        // Setup
        when(mockProductService.deleteProduct(0L)).thenReturn(true);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/seller/delete/{productId}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("true");
        verify(mockProductService).deleteProduct(0L);
    }

    @Test
    void testShowBids() throws Exception {
        // Setup

        // Configure BidService.getAllBidsOnProductById(...).
        final List<Bid> bids = new ArrayList<Bid>();
        bids.add(new Bid(0L, 0.0, 0L, new Buyer(0L, "firstName", "lastName", 0L, 0L, "address", "email", "city", "state", new HashSet<>())));
        when(mockBidService.getAllBidsOnProductById(0L)).thenReturn(bids);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/seller/show-bids/{productId}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(MasterData.asJsonString(bids));
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
        final List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(new ProductDto(1L, "productName", new BigDecimal("0.00"), "shortDescription", "detailedDescription", LocalDate.of(2020, 1, 1), "category"));
        when(mockProductService.getAllProducts()).thenReturn(productDtos);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/seller/fetch-products")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[{\"productId\":1,\"productName\":\"productName\",\"startingPrice\":0.00,\"shortDescription\":\"shortDescription\",\"detailedDescription\":\"detailedDescription\",\"bidEndDate\":\"2020-01-01\",\"category\":\"category\"}]");
    }

    @Test
    void testFetchProducts_ProductServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockProductService.getAllProducts()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/seller/fetch-products")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }
}
