package com.wells.qart.eAuction.boundary;
import java.time.LocalDate;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.wells.qart.eAuction.dto.*;
import com.wells.qart.eAuction.testutils.MasterData;
import com.wells.qart.eAuction.testutils.TestUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
//import org.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.wells.qart.eAuction.testutils.TestUtils.*;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {
    private static Validator validator;

    // ----------------------------------------------------------------------------------------------
    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterAll
    public static void afterAll() {
        TestUtils.testReport();
    }

    @Test
    public void testFirstNameNotNull() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setFirstName("");
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }

    @Test
    public void testFirstNameMinFive() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setFirstName("Abcd");
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }

    @Test
    public void testFirstNameMaxThirty() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        String name = "";
        for (int i = 0; i < 40; i++) {
            name.concat("A");
        }
        sellerDto.setFirstName(name);
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }
    @Test
    public void testLastNameNotNull() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setLastName("");
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }

    @Test
    public void testLastNameMin3() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setLastName("Ab");
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }

    @Test
    public void testLastNameMax25() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        String name = "";
        for (int i = 0; i < 26; i++) {
            name.concat("A");
        }
        sellerDto.setLastName(name);
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }

    @Test
    public void testMobileNotNull() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setPhoneNumber(null);
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }

    @Test
    public void testMobileMinTen() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setPhoneNumber(12345L);
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }

    @Test
    public void testMobileMaxTen() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();

        sellerDto.setPhoneNumber(123456789012L);
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }
    @Test
    public void testEmailNotNull() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setEmail("");
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }

    @Test
    public void testEmailMinFive() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setEmail("Abcd");
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }

    @Test
    public void testEmailMaxThirty() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        String name = "";
        for (int i = 0; i < 40; i++) {
            name.concat("A");
        }
        sellerDto.setEmail(name);
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }

    @Test
    public void testEmailValidFormat() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setEmail("abcde");
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        wellsAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
    }
    @Test
    public void testProductNameNotNull() throws Exception {
        ProductDto productDto = MasterData.getProductDto();
        productDto.setProductName(null);
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testProductNameMinFive() throws Exception {
        ProductDto productDto = MasterData.getProductDto();
        productDto.setProductName("Abyz");
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testProductNameMaxThirty() throws Exception {
        ProductDto productDto = MasterData.getProductDto();
        String name = "";
        for (int i = 0; i < 31; i++) {
            name.concat("A");
        }
        productDto.setProductName(name);
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testProductStartingPriceNotNull() throws Exception {
        ProductDto productDto = MasterData.getProductDto();
        productDto.setStartingPrice(null);
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testBidAmountNotNull() throws Exception {
        BidDto productDto = MasterData.getBidDto();
        productDto.setBidAmount(null);
        Set<ConstraintViolation<BidDto>> violations = validator.validate(productDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }


    @Test
    public void testProductBidEndDateNotNull() throws Exception {
        ProductDto productDto = MasterData.getProductDto();
        productDto.setBidEndDate(null);
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testProductLastDateOfBiddingNotPastDate() throws Exception {
        ProductDto productDto = MasterData.getProductDto();
        productDto.setBidEndDate(LocalDate.of(2020, 10, 20));
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testProductCategoryNotNull() throws Exception {
        ProductDto productDto = MasterData.getProductDto();
        productDto.setCategory(null);
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }
    @Test
    public void testBuyerFirstNameNotNull() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        customerDto.setFirstName(null);
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testBuyerFirstNameMinFive() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        customerDto.setFirstName("Abyz");
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testBuyerFirstNameMaxThirty() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        String username = "";
        for (int i = 0; i < 31; i++) {
            username.concat("A");
        }
        customerDto.setFirstName(username);
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testBuyerLastNameNotNull() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        customerDto.setLastName(null);
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testBuyerLastNameMinThree() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        customerDto.setLastName("Ab");
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testBuyerLastNameMax25() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        String username = "";
        for (int i = 0; i < 26; i++) {
            username.concat("A");
        }
        customerDto.setLastName(username);
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }



    @Test
    public void testCustomerEmailNotNull() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        customerDto.setEmail(null);
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCustomerEmailMinFive() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        customerDto.setEmail("Abyz");
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCustomerEmailMaxThirty() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        String email = "";
        for (int i = 0; i < 40; i++) {
            email.concat("A");
        }
        customerDto.setEmail(email);
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCustomerEmailValidFormat() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        customerDto.setEmail("abc");
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCustomerPhoneNumberNotNull() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        customerDto.setPhoneNumber(null);
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCustomerPhoneNumberMinTen() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        customerDto.setPhoneNumber(12345L);
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testcustomerPhoneNumberMaxTen() throws Exception {
        BuyerDto customerDto = MasterData.getBuyerDto();
        customerDto.setPhoneNumber(123456789012L);
        Set<ConstraintViolation<BuyerDto>> violations = validator.validate(customerDto);
        wellsAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }



}
