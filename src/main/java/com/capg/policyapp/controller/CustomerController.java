package com.capg.policyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Customer;
import com.capg.policyapp.service.CustomerService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/customer")
public class CustomerController {

@Autowired
private CustomerService customerService;	

@PostMapping("/addCustomer")
public ResponseEntity<Customer> addCustomer(@RequestBody @Valid  Customer customer){
	Customer customerObj=customerService.addCustomer(customer);
	ResponseEntity<Customer> rs = new ResponseEntity<Customer>(customerObj, HttpStatus.OK);
	return rs;
}

@PutMapping("/updateCustomerEmailId/{customerId}/{emailId}")
public ResponseEntity<Customer> updateCustomerEmailId(@PathVariable long customerId, @PathVariable String emailId) throws InvalidEntityException {
    Customer customerObj = customerService.updateCustomerEmailId(customerId, emailId);
    ResponseEntity<Customer> rs = new ResponseEntity<Customer>(customerObj, HttpStatus.OK);
    return rs;
}

@GetMapping("/viewAllCustomers")
public ResponseEntity<List<Customer>> viewAllCustomers() {
	List <Customer> list=customerService.viewAllCustomers();
	ResponseEntity<List<Customer>> rs=new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	return rs;
}

@GetMapping("/viewAllCustomers/{customerId}")
public ResponseEntity<Customer> viewCustomerById(@PathVariable long customerId)throws InvalidEntityException {
	Customer customerObj=customerService.viewCustomerById(customerId);
	ResponseEntity<Customer> rs = new ResponseEntity<Customer>(customerObj,HttpStatus.OK);
	return rs;
}

@GetMapping("/viewCustomerByPolicy/{policyId}")
public ResponseEntity<Customer> viewSchemeByPolicy(@PathVariable long policyId) {
	 Customer customer=customerService.viewCustomerByPolicy(policyId);
	 ResponseEntity<Customer> rs=new ResponseEntity<Customer> (customer,HttpStatus.OK);
	return rs;
}
}
