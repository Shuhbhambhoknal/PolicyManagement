package com.capg.policyapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Customer;
import com.capg.policyapp.model.Policy;
import com.capg.policyapp.repository.CustomerRepository;
import com.capg.policyapp.repository.PolicyRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PolicyRepository policyRepository;

	public Customer addCustomer(Customer customerObj) { 
		Customer customer=customerRepository.save(customerObj);
		return customer;
	}

	@Override
	public Customer updateCustomerEmailId(long customerId, String emailId) throws InvalidEntityException {
		Optional<Customer> opCustomer = customerRepository.findById(customerId);
		if (opCustomer.isPresent()) {
			Customer customer = opCustomer.get();
			customer.setEmailId(emailId);
			customerRepository.saveAndFlush(customer);
			return customer;
		} else {
			throw new InvalidEntityException("Customer not found with ID: " + customerId);
		}
	}

	@Override
	public List<Customer> viewAllCustomers() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	@Override
	public Customer viewCustomerById(long customerId) throws InvalidEntityException {
		Optional<Customer> opCustomer = customerRepository.findById(customerId);
		if (opCustomer.isPresent()) {
			return opCustomer.get();
		} else {
			throw new InvalidEntityException("Customer not found with ID: " + customerId);
		}
	}

	@Override
	public Customer viewCustomerByPolicy(long policyId) {
		Optional<Policy> optionalPolicy = policyRepository.findById(policyId);
		if (optionalPolicy.isPresent()) {
			Policy policy = optionalPolicy.get();
			Customer customer = policy.getCustomer();
			return customer;
		} else {
			throw new EntityNotFoundException("Policy not found with ID: " + policyId);
		}
	}
}
