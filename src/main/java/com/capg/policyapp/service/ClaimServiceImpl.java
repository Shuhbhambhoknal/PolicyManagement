package com.capg.policyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.policyapp.dao.ClaimDAOImpl;
import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Claim;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	ClaimDAOImpl claimDAOImpl;

	@Override
	public Claim addClaim(Claim claimObj, long policyId) throws InvalidEntityException {
		Claim addedClaim = claimDAOImpl.addClaim(claimObj, policyId);
		return addedClaim;
	}

	@Override
	public Claim updateClaimStatus(long claimId, String claimStatus) throws InvalidEntityException {
		Claim updateClaims = claimDAOImpl.updateClaimStatus(claimId, claimStatus);
		if (updateClaims == null) {
			throw new InvalidEntityException("ClaimId does not exit");
		}
		return updateClaims;
	}

	@Override
	public List<Claim> viewAllClaims() {
		List<Claim> viewAllClaim = claimDAOImpl.viewAllClaims();
		return viewAllClaim;
	}

	@Override
	public Claim viewClaimById(long claimId) throws InvalidEntityException {
		Claim byId = claimDAOImpl.viewClaimById(claimId);
		if (byId == null) {
			throw new InvalidEntityException("ClaimId does not exit");
		}
		return byId;
	}
}
