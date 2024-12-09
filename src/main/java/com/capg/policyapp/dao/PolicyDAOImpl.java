package com.capg.policyapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Customer;
import com.capg.policyapp.model.Policy;
import com.capg.policyapp.model.Scheme;
import com.capg.policyapp.repository.CustomerRepository;
import com.capg.policyapp.repository.PolicyRepository;
import com.capg.policyapp.repository.SchemeRepository;
@Service
public class PolicyDAOImpl implements PolicyDAO{
	
	@Autowired
	private PolicyRepository policyRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private SchemeRepository schemeRepository;
	
	@Override
	public Policy addPolicy(Policy policy, long customerId, long schemeId) throws InvalidEntityException {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Optional<Scheme> schemeOptional = schemeRepository.findById(schemeId);
        if (customerOptional.isPresent() && schemeOptional.isPresent()) {
            Customer customer = customerOptional.get();
            Scheme scheme = schemeOptional.get();
            policy.setCustomer(customer);
            policy.setScheme(scheme);
            Policy savedPolicy = policyRepository.saveAndFlush(policy);
            return savedPolicy;
        } else {
            throw new InvalidEntityException("Customer or Scheme not found with provided IDs");
        }
    }
	
	@Override
	public Policy updatePolicyStatus(long policyId, String policyStatus) throws InvalidEntityException {
        Optional<Policy> opPolicy = policyRepository.findById(policyId);
        if (opPolicy.isPresent()) {
            Policy policyObj = opPolicy.get();
            policyObj.setPolicyStatus(policyStatus);
            Policy policy = policyRepository.saveAndFlush(policyObj);
            return policy;
        } else {
            throw new InvalidEntityException("Policy not found with ID: " + policyId);
        }
    }

	@Override
	public List<Policy> viewAllPolicies() {
		List<Policy> list = policyRepository.findAll();
		return list;
	}

	@Override
	public Policy viewPolicyById(long policyId) throws InvalidEntityException {
        Optional<Policy> opPolicy = policyRepository.findById(policyId);
        if (opPolicy.isPresent()) {
            return opPolicy.get();
        } else {
            throw new InvalidEntityException("Policy not found with ID: " + policyId);
        }
    }
    }


