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
}
