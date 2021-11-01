package com.wells.qart.eAuction.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
@Data
@NoArgsConstructor
public class BuyerDto {

	@NotNull
	private Long buyerId;
	@NotBlank
	@Length(min = 5, max = 30)
	private String firstName;

	@NotBlank
	@Length(min = 3, max = 25)
	private String lastName;

//	@NotNull
//	@Min(100000)
//	@Max(999999)
	private Long pin;
	@NotNull
	@Min(1000000000)
	@Max(9999999999L)
	private Long phoneNumber;
	@NotBlank
	private String address;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String city;
	@NotBlank
	private String state;



}
