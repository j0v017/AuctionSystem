package com.wells.qart.eAuction.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuyerDtoTest {

    private BuyerDto buyerDtoUnderTest;

    @BeforeEach
    void setUp() {
        buyerDtoUnderTest = new BuyerDto();
    }


    @Test
    void testToString() {
        assertThat(buyerDtoUnderTest.toString()).isEqualTo("BuyerDto(buyerId=null, firstName=null, lastName=null, pin=null, phoneNumber=null, address=null, email=null, city=null, state=null)");
    }
}
