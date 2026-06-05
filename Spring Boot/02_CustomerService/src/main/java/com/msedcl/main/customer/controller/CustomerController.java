package com.msedcl.main.customer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.customer.common.ApiResponse;
import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;
import com.msedcl.main.customer.service.CustomerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Validated
@Slf4j
@RestController
@RequestMapping("customerapi")
@AllArgsConstructor
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping("customers/customer")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> addNewCustomer(
		@Valid	@RequestBody CustomerRequestDTO customerRequestDTO) {
		log.info("request received to add new customer");
		log.info(customerRequestDTO.toString());

		CustomerResponseDTO customerResponseDTO = customerService.createCustomer(customerRequestDTO);
		log.info("New customer added sucessfully");
		log.info(customerResponseDTO.toString());

		ApiResponse<CustomerResponseDTO> apiResponse = new ApiResponse<CustomerResponseDTO>("CREATED",
				"NEW CUSTOMER ADDED SUCESSFULLY", customerResponseDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);

	}

	@GetMapping("customers/{customerId}")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> getSingleByCustomerId(@PathVariable int customerId) {
		log.info("Request received  to retrive customer details");
		log.info("customer id ::" + customerId);

		CustomerResponseDTO customerResponseDTO = customerService.getCustomerByCustomerId(customerId);
		log.info("Customer  find by customer id sucessfully");
		log.info(customerResponseDTO.toString());

		ApiResponse<CustomerResponseDTO> apiResponse = new ApiResponse<CustomerResponseDTO>("FOUND",
				"CUSTOMER DETAILS Retrived SUCESSFULY", customerResponseDTO);

		return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);

	}

	@GetMapping("customersEmail/{email}")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> getConsumerByEmail(@PathVariable String email) {
		log.info("Request received  to retrive customer details fro emails");
		log.info("eamil id ::" + email);
		CustomerResponseDTO customerResponseDTO = customerService.getCustomerByEmail(email);
		log.info("Email id found successfull");
		log.info(customerResponseDTO.toString());

		ApiResponse<CustomerResponseDTO> apiResponse = new ApiResponse<CustomerResponseDTO>("FOUND",
				"Email data of customer found sucessfully", customerResponseDTO);
		return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);

	}

	@GetMapping("customersAll")
	public ResponseEntity<ApiResponse<List<CustomerResponseDTO>>> getAllCustomers() {
		log.info("Request to retrive all customers details ");
		
		List<CustomerResponseDTO> customerResponseDTOList= customerService.getAllCustomers();
		log.info("All customers retrive sucessfully");
		customerResponseDTOList.forEach(c-> log.info(c.toString()));
		ApiResponse<List<CustomerResponseDTO>> apiResponse=  new ApiResponse<List<CustomerResponseDTO>>("OK",
				"Email data of customer found sucessfully", customerResponseDTOList);
		return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);

	}

}
