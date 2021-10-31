package com.wells.qart.eAuction.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SellerTest {

    private Seller sellerUnderTest;

    @BeforeEach
    void setUp() {
        sellerUnderTest = new Seller(1L, "firstName", "lastName", 777777, 7777777777L, "address", "email@gmail.com", "city", "state");
    }

    @Test
    void testGetName() {
        assertThat(sellerUnderTest.getName()).isEqualTo("firstName");
    }

    @Test
    void testSetName() {
        // Setup

        // Run the test
        sellerUnderTest.setName("name");

        // Verify the results
    }
}
