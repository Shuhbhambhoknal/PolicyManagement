package com.capg.policyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.policyapp.dao.CustomerDAO;
import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
    
	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public Customer addCustomer(Customer customerObj) {
		return customerDAO.addCustomer(customerObj);
	}

	@Override
	public Customer updateCustomerEmailId(long customerId, String emailId) throws InvalidEntityException {
		return customerDAO.updateCustomerEmailId(customerId, emailId);
	}

	@Override
	public List<Customer> viewAllCustomers() {
		return customerDAO.viewAllCustomers();
	}

	@Override
	public Customer viewCustomerById(long customerId) throws InvalidEntityException {
		// TODO Auto-generated method stub
		return customerDAO.viewCustomerById(customerId);
	}

	@Override
	public Customer viewCustomerByPolicy(long policyId) {
		// TODO Auto-generated method stub
		return customerDAO.viewCustomerByPolicy(policyId);
	}


}
