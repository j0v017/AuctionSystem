package com.wells.qart.eAuction.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "buyers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long buyerId;
	@NotBlank
	@Length(min = 5, max = 30)
	private String firstName;
	@NotBlank
	@Length(min = 3, max = 25)
	private String lastName;
	private Long pin;
	@NotNull
	@Min(1000000000)
	@Max(9999999999L)
	private Long phoneNumber;
	private String address;
	@Email
	@NotBlank
	private String email;
	private String city;
	private String state;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="buyer")
	@JsonIgnore
	private Set<Bid> bids = new HashSet<>();
}
