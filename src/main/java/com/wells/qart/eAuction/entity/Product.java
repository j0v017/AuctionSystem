package com.wells.qart.eAuction.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	private String productName;
	private BigDecimal startingPrice;
	private String shortDescription;
	private String detailedDescription;
	@Future
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	LocalDate bidEndDate;
	@Pattern(regexp = "Painting|Sculptor|Ornament", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String category;
//
//	@ElementCollection
//	List<String> category=List.of("Painting", "Sculptor", "Ornament");

//	public Product() {
//	}
//
//	public Product(Long productId, Integer startingPrice, String shortDescription, String detailedDescription, Date bidEndDate, List<String> category) {
//		super();
//		this.productId = productId;
//		this.startingPrice=startingPrice;
//		this.shortDescription=shortDescription;
//		this.detailedDescription=detailedDescription;
//		this.bidEndDate=bidEndDate;
//		this.category=category;
//	}
//
//	public Long getProductId() {
//		return productId;
//	}
//
//	public void setProductId(Long productId) {
//		this.productId = productId;
//	}
//
//	public Long getProductName() {
//		return productName;
//	}
//
//	public void setProductName(Long productName) {
//		this.productName = productName;
//	}
//
//	public Integer getStartingPrice() {
//		return startingPrice;
//	}
//
//	public void setStartingPrice(Integer startingPrice) {
//		this.startingPrice = startingPrice;
//	}
//
//	public String getShortDescription() {
//		return shortDescription;
//	}
//
//	public void setShortDescription(String shortDescription) {
//		this.shortDescription = shortDescription;
//	}
//
//	public String getDetailedDescription() {
//		return detailedDescription;
//	}
//
//	public void setDetailedDescription(String detailedDescription) {
//		this.detailedDescription = detailedDescription;
//	}
//
//	public LocalDate getBidEndDate() {
//		return bidEndDate;
//	}
//
//	public void setBidEndDate(Date bidEndDate) {
//		this.bidEndDate = bidEndDate;
//	}
//
//	public List<String> getCategory() {
//		return category;
//	}
//
//	public void setCategory(List<String> category) {
//		this.category = category;
//	}
}
