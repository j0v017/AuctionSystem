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
    void testEquals() {
        assertThat(buyerDtoUnderTest.equals("o")).isTrue();
    }

    @Test
    void testHashCode() {
        assertThat(buyerDtoUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(buyerDtoUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testCanEqual() {
        assertThat(buyerDtoUnderTest.canEqual("other")).isTrue();
    }
}
