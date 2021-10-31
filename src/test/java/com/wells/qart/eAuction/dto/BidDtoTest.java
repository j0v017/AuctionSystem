package com.wells.qart.eAuction.dto;

import com.wells.qart.eAuction.entity.Buyer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BidDtoTest {

    @Mock
    private Buyer mockBuyer;

    private BidDto bidDtoUnderTest;

    @BeforeEach
    void setUp() {
        bidDtoUnderTest = new BidDto(1L, 1.0, 1L, mockBuyer);
    }


    @Test
    void testToString() {
        assertThat(bidDtoUnderTest.toString()).isEqualTo("BidDto(id=1, bidAmount=1.0, productId=1, buyer=mockBuyer)");
    }
}
