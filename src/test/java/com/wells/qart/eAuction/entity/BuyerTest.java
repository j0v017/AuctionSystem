package com.wells.qart.eAuction.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BuyerTest {

    private Buyer buyerUnderTest;

    @BeforeEach
    void setUp() {
        buyerUnderTest = new Buyer(0L, "firstName", "lastName", 999999L, 9999999999L, "address", "email@gmail.com", "city", "state", Set.of(new Bid(1L, 9999.0, 1L, new Buyer(1L, "firstName", "lastName", 999999L, 9999999999L, "address", "email@gmail.com", "city", "state", Set.of()))));
    }


    @Test
    void testToString() {
        assertThat(buyerUnderTest.toString()).isEqualTo("Buyer(buyerId=0, firstName=firstName, lastName=lastName, pin=999999, phoneNumber=9999999999, address=address, email=email@gmail.com, city=city, state=state, bids=[Bid(bidId=1, bidAmount=9999.0, productId=1, buyer=Buyer(buyerId=1, firstName=firstName, lastName=lastName, pin=999999, phoneNumber=9999999999, address=address, email=email@gmail.com, city=city, state=state, bids=[]))])");
    }

}
