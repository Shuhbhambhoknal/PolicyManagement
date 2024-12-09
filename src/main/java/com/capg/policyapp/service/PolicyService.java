package com.capg.policyapp.service;

import java.util.List;

import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Policy;

public interface PolicyService {
	
	public Policy addPolicy (Policy policy, long customerId, long schemeId) throws InvalidEntityException ;
	public Policy updatePolicyStatus (long policyId, String policyStatus) throws InvalidEntityException;
	public List<Policy> viewAllPolicies();
	public Policy viewPolicyById (long policyId) throws InvalidEntityException;
}
