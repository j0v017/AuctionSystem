package com.wells.qart.eAuction.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    private Product productUnderTest;

    @BeforeEach
    void setUp() {
        productUnderTest = new Product(1L, "productName", new BigDecimal("88.00"), "shortDescription", "detailedDescription", LocalDate.of(2022, 1, 1), "ornament");
    }

    @Test
    void testToString() {
        assertThat(productUnderTest.toString()).isEqualTo("Product(productId=1, productName=productName, startingPrice=88.00, shortDescription=shortDescription, detailedDescription=detailedDescription, bidEndDate=2022-01-01, category=ornament)");
    }
}
