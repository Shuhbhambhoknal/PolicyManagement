package com.capg.policyapp.dao;

import java.util.List;

import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Claim;

public interface ClaimDAO {
	
	public Claim addClaim(Claim claimObj, long policyId) throws InvalidEntityException;
	public Claim updateClaimStatus(long claimId, String claimStatus) throws InvalidEntityException;
	public List<Claim> viewAllClaims();
	public Claim viewClaimById(long claimId) throws InvalidEntityException;

}
