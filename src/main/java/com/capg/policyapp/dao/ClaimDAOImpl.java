package com.capg.policyapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Claim;
import com.capg.policyapp.model.Policy;
import com.capg.policyapp.repository.ClaimRepository;
import com.capg.policyapp.repository.PolicyRepository;
@Service
public class ClaimDAOImpl implements ClaimDAO{
	
	@Autowired
    private ClaimRepository claimRepository;
	@Autowired
	private PolicyRepository policyRepository;
	
	@Override
	public Claim addClaim(Claim claimObj, long policyId) throws InvalidEntityException {
	    Optional<Policy> optionalPolicy = policyRepository.findById(policyId);
	    if (optionalPolicy.isPresent()) {
	        Policy policy = optionalPolicy.get();
	        claimObj.setPolicy(policy);
	        Claim claim = claimRepository.saveAndFlush(claimObj);
	        return claim;
	    } else {
	        throw new InvalidEntityException("Policy not found with ID: " + policyId);
	    }
	}

	@Override
	public Claim updateClaimStatus(long claimId, String claimStatus) throws InvalidEntityException {
	    Optional<Claim> opClaim = claimRepository.findById(claimId);
	    if (opClaim.isPresent()) {
	        Claim claim = opClaim.get();
	        claim.setClaimStatus(claimStatus);
	        Claim claim2 = claimRepository.saveAndFlush(claim);
	        return claim2;
	    } else {
	        throw new InvalidEntityException("Claim not found with ID: " + claimId);
	    }
	}

	@Override
	public List<Claim> viewAllClaims() {
		List<Claim> list = claimRepository.findAll();
		return list;
	}

	@Override
	public Claim viewClaimById(long claimId) throws InvalidEntityException {
	    Optional<Claim> opClaim = claimRepository.findById(claimId);
	    if (opClaim.isPresent()) {
	        Claim claim = opClaim.get();
	        return claim;
	    } else {
	        throw new InvalidEntityException("Claim not found with ID: " + claimId);
	    }
	}

}
