package com.capg.policyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.policyapp.dao.PolicyDAO;
import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Policy;

@Service
public class PolicyServiceImpl implements PolicyService {
	
	@Autowired
	private PolicyDAO policyDao;

	@Override
	public Policy addPolicy(Policy policy, long customerId, long schemeId) throws InvalidEntityException{
		// TODO Auto-generated method stub
		return policyDao.addPolicy(policy, customerId, schemeId);
	}

	@Override
	public Policy updatePolicyStatus(long policyId, String policyStatus) throws InvalidEntityException {
		// TODO Auto-generated method stub
		return policyDao.updatePolicyStatus(policyId, policyStatus);
	}

	@Override
	public List<Policy> viewAllPolicies() {
		// TODO Auto-generated method stub
		return policyDao.viewAllPolicies();
	}

	@Override
	public Policy viewPolicyById(long policyId) throws InvalidEntityException {
		// TODO Auto-generated method stub
		return policyDao.viewPolicyById(policyId);
	}
}
