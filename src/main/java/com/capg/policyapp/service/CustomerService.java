package com.capg.policyapp.service;

import java.util.List;

import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Customer;

public interface CustomerService {
	public Customer addCustomer (Customer customerObj);
	public Customer updateCustomerEmailId (long customerId, String emailId) throws InvalidEntityException;
	public List<Customer> viewAllCustomers();
	public Customer viewCustomerById (long customerId) throws InvalidEntityException;
	public Customer viewCustomerByPolicy(long policyId);
}
