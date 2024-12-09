package com.capg.policyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Policy;
import com.capg.policyapp.service.PolicyService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/policy")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	@PostMapping("/addPolicy/{customerId}/{schemeId}")
	public ResponseEntity<Policy> addPolicy(@RequestBody @Valid Policy policy,@PathVariable long customerId,@PathVariable long schemeId) throws InvalidEntityException {
		Policy policy1=policyService.addPolicy(policy, customerId, schemeId);
		return ResponseEntity.ok(policy1);
	}
	
	@PutMapping("/updatePolicyStatus/{policyId}/{policyStatus}")
	public ResponseEntity<Policy> updatePolicyStatus(@PathVariable long policyId,@PathVariable String policyStatus)throws InvalidEntityException {
		Policy policy = policyService.updatePolicyStatus(policyId, policyStatus);
		ResponseEntity<Policy> policEntity=new ResponseEntity<Policy>(policy,HttpStatus.OK);
		return policEntity;
	}
	
	@GetMapping("/viewAllPolicies")
	public ResponseEntity<List<Policy>> viewAllPolicies() {
		List<Policy> policyList = policyService.viewAllPolicies();
		return new ResponseEntity<List<Policy>>(policyList,HttpStatus.OK);
	}
	
	@GetMapping("/viewPolicyById/{policyId}")
	public ResponseEntity<Policy> viewPolicyById(@PathVariable long policyId) throws InvalidEntityException {
		Policy policy = policyService.viewPolicyById(policyId);
		return new ResponseEntity<Policy>(policy,HttpStatus.OK);
 	}
}