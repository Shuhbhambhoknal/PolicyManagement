package com.capg.policyapp.service;

import java.util.List;

import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Scheme;

public interface SchemeService {

	public Scheme  addScheme (Scheme schemeObj);
	
	public Scheme updateRateOfInterest (long schemeId, double rateOfInterest) throws InvalidEntityException;
	
	public List< Scheme> viewAllSchemes();
	
	public Scheme viewSchemeById (long schemeId) throws InvalidEntityException;
	
	public Scheme viewSchemeByPolicy (long policyId);
	

}
