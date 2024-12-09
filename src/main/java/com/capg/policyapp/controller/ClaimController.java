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
import com.capg.policyapp.model.Claim;
import com.capg.policyapp.service.ClaimService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/claim")
public class ClaimController {
	
	@Autowired
    private ClaimService claimService;

	@PostMapping("/addClaims/{policyId}")
	public ResponseEntity<Claim> addClaim(@RequestBody @Valid Claim claimObj, @PathVariable long policyId) throws InvalidEntityException {
		Claim addedClaim = claimService.addClaim(claimObj, policyId);
		return new ResponseEntity<>(addedClaim, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateClaimStatus/{claimId}/{claimStatus}")
	public ResponseEntity<Claim> updateClaimStatus(@PathVariable @Valid long claimId, @PathVariable String claimStatus) throws InvalidEntityException{
		Claim updateClaimStatus = claimService.updateClaimStatus(claimId, claimStatus);
		return new ResponseEntity<>(updateClaimStatus, HttpStatus.CREATED);
	}
	
	@GetMapping("/viewAllClaims")
	public ResponseEntity<List<Claim>> viewAllClaims() {
		List<Claim> claims = claimService.viewAllClaims();
		return new ResponseEntity<>(claims, HttpStatus.OK);
	}
	
	@GetMapping("/viewClaimById/{claimId}")
	public ResponseEntity<Claim> viewClaimById(@PathVariable long claimId) throws InvalidEntityException {
		Claim claim = claimService.viewClaimById(claimId);
		return new ResponseEntity<>(claim, HttpStatus.OK);
	}

}
