package com.wells.qart.eAuction.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BidTest {

    @Mock
    private Buyer mockBuyer;

    private Bid bidUnderTest;

    @BeforeEach
    void setUp() {
        bidUnderTest = new Bid(1L, 9999.0, 1L, mockBuyer);
    }

    @Test
    void testToString() {
        assertThat(bidUnderTest.toString()).isEqualTo("Bid(bidId=1, bidAmount=9999.0, productId=1, buyer=mockBuyer)");
    }
}
