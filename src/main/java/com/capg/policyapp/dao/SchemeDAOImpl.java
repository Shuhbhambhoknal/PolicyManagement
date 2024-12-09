package com.capg.policyapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Policy;
import com.capg.policyapp.model.Scheme;
import com.capg.policyapp.repository.PolicyRepository;
import com.capg.policyapp.repository.SchemeRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class SchemeDAOImpl implements SchemeDAO{
	@Autowired
	private SchemeRepository schemeRepository;
	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public Scheme addScheme(Scheme schemeObj) {
		Scheme scheme = schemeRepository.save(schemeObj);
		return scheme;
	}

	@Override
	public Scheme updateRateOfInterest(long schemeId, double rateOfInterest) throws InvalidEntityException {
		Optional<Scheme> opScheme=schemeRepository.findById(schemeId);
		Scheme scheme=opScheme.get();
		scheme.setRateOfIntrest(rateOfInterest);
		schemeRepository.saveAndFlush(scheme);
		return scheme;
	}

	@Override
	public List<Scheme> viewAllSchemes() {
		List<Scheme> list=schemeRepository.findAll();
		return list;
	}

	@Override
	public Scheme viewSchemeById(long schemeId) throws InvalidEntityException {
		Optional<Scheme> opScheme =schemeRepository.findById(schemeId);
		return opScheme.get();
	}

	@Override
	public Scheme viewSchemeByPolicy(long policyId) {
		 Optional<Policy> optionalPolicy = policyRepository.findById(policyId);
		    if (optionalPolicy.isPresent()) {
		        Policy policy = optionalPolicy.get();
		        Scheme scheme = policy.getScheme();
		        return scheme;
		    } else {
		    	throw new EntityNotFoundException("Policy not found with ID: " + policyId); 
		    }
	}
}
