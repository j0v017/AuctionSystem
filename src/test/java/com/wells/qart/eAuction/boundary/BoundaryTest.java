    package com.wells.qart.eAuction.boundary;
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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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
//        sellerDto.setLastName("xyz");
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty(), TestUtils.boundaryTestFile);
    }

    @Test
    public void testFirstNameMinFive() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setFirstName("Abcd");
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty(), TestUtils.boundaryTestFile);
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
        TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty(), TestUtils.boundaryTestFile);
    }

    @Test
    public void testUserMobileNotNull() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setPhoneNumber(null);
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty(), TestUtils.boundaryTestFile);
    }

    @Test
    public void testUserMobileMinTen() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setPhoneNumber(12345L);
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty(), TestUtils.boundaryTestFile);
    }

    @Test
    public void testUserMobileMaxTen() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();

        sellerDto.setPhoneNumber(123456789012L);
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty(), TestUtils.boundaryTestFile);
    }
    @Test
    public void testEmailNotNull() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setEmail("");
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty(), TestUtils.boundaryTestFile);
    }

    @Test
    public void testEmailMinFive() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setEmail("Abcd");
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
    }

    @Test
    public void testUserEmailMaxThirty() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        String name = "";
        for (int i = 0; i < 40; i++) {
            name.concat("A");
        }
        sellerDto.setEmail(name);
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
    }

    @Test
    public void testUserEmailValidFormat() throws Exception {
        SellerDto sellerDto = MasterData.getSellerDto();
        sellerDto.setEmail("abcde");
        Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
        TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
    }
}
