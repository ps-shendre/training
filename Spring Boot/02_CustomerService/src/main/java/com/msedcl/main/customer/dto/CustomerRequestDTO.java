package com.msedcl.main.customer.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDTO {
	@NotBlank(message = "Name caanot be blank")
	@Length(min = 2, max = 50)
	private String name;

	@Email(message = "Invalid email id")
	@NotBlank(message = "Email id cannot be blank")
	private String email;

	@NotBlank(message = "Mobile no cannot be blank")
	@Length(min = 10, max = 13)
	private String mobileNumber;
}
