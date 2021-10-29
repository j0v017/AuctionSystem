package com.wells.qart.eAuction.dto;

import com.wells.qart.eAuction.entity.Seller;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class ProductDto {
    @NotNull
    private Long productId;
    @NotNull
    @Length(min = 5, max = 30)
    private String productName;
    private BigDecimal startingPrice;
    private String shortDescription;
    private String detailedDescription;
    @Future
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate bidEndDate;

    private Seller seller;
    @Pattern(regexp = "Painting|Sculptor|Ornament", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String category;
    //List<String> category=List.of("Painting", "Sculptor", "Ornament");

    public ProductDto(){}

    public ProductDto(Long productId, String productName, BigDecimal startingPrice, String shortDescription, String detailedDescription, LocalDate bidEndDate, String category) {
        this.productId = productId;
        this.productName = productName;
        this.startingPrice = startingPrice;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.bidEndDate = bidEndDate;
        this.category = category;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(BigDecimal startingPrice) {
        this.startingPrice = startingPrice;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public @Future @NotNull LocalDate getBidEndDate() {
        return bidEndDate;
    }

    public void setBidEndDate(@Future @NotNull LocalDate bidEndDate) {
        this.bidEndDate = bidEndDate;
    }

    public @Pattern(regexp = "Painting|Sculptor|Ornament", flags = Pattern.Flag.CASE_INSENSITIVE) String getCategory() {
        return category;
    }

    public void setCategory(@Pattern(regexp = "Painting|Sculptor|Ornament", flags = Pattern.Flag.CASE_INSENSITIVE) String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName) && Objects.equals(startingPrice, that.startingPrice) && Objects.equals(shortDescription, that.shortDescription) && Objects.equals(detailedDescription, that.detailedDescription) && Objects.equals(bidEndDate, that.bidEndDate) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, startingPrice, shortDescription, detailedDescription, bidEndDate, category);
    }
}
