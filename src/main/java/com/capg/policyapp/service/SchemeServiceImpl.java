package com.capg.policyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.policyapp.dao.SchemeDAO;
import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Scheme;

@Service
public class SchemeServiceImpl implements SchemeService {

	@Autowired
	SchemeDAO schemeDAO;

	@Override
	public Scheme addScheme(Scheme schemeObj) {
		// TODO Auto-generated method stub
		return schemeDAO.addScheme(schemeObj);
	}

	@Override
	public Scheme updateRateOfInterest(long schemeId, double rateOfInterest) throws InvalidEntityException {
		// TODO Auto-generated method stub
		return schemeDAO.updateRateOfInterest(schemeId, rateOfInterest);
	}

	@Override
	public List<Scheme> viewAllSchemes() {
		// TODO Auto-generated method stub
		return schemeDAO.viewAllSchemes();
	}

	@Override
	public Scheme viewSchemeById(long schemeId) throws InvalidEntityException {
		// TODO Auto-generated method stub
		return schemeDAO.viewSchemeById(schemeId);
	}

	@Override
	public Scheme viewSchemeByPolicy(long policyId) {
		// TODO Auto-generated method stub
		return schemeDAO.viewSchemeByPolicy(policyId);
	}

	
}
