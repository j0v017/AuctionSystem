package com.wells.qart.eAuction.controller;

import com.wells.qart.eAuction.dto.BidDto;
import com.wells.qart.eAuction.entity.Bid;
import com.wells.qart.eAuction.entity.Buyer;
import com.wells.qart.eAuction.service.BidService;
import com.wells.qart.eAuction.service.BuyerService;
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

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BuyerRestController.class)
class BuyerRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BidService mockBidService;
    @MockBean
    private BuyerService mockBuyerService;

    @Test
    void testAddBid() throws Exception {
        // Setup

        // Configure BidService.placeBid(...).
        Set<Bid> bidSet = new HashSet<>();
        bidSet.add(new Bid(2L, 111111.0, 1L, null));
        final BidDto bidDto = new BidDto(2L, 111111.0, 1L, new Buyer(1L, "firstName", "lastName", 222222L, 9999999999L, "address", "email@gmail.com", "city", "state", bidSet));
        when(mockBidService.placeBid(new BidDto(2L, 111111.0, 1L, new Buyer(1L, "firstName", "lastName", 222222L, 9999999999L, "address", "email@gmail.com", "city", "state", bidSet)))).thenReturn(bidDto);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/buyer/place-bid")
                        .content(MasterData.asJsonString(bidDto)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(MasterData.asJsonString(bidDto));
        verify(mockBidService).placeBid(new BidDto(2L, 111111.0, 1L, new Buyer(1L, "firstName", "lastName", 222222L, 9999999999L, "address", "email@gmail.com", "city", "state", new HashSet<>())));
    }

    @Test
    void testUpdateBid() throws Exception {
        // Setup
        when(mockBidService.updateBid(0L, "buyerEmailld", 0.0)).thenReturn(true);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(put("/buyer/update-bid/{productId}/{buyerEmailld}/{newBidAmount}", 0, "buyerEmailld", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("true");
    }
}
