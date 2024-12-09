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
import com.capg.policyapp.model.Scheme;
import com.capg.policyapp.service.SchemeService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/scheme")
public class SchemeController {
	
	@Autowired
	private SchemeService schemeService ;	
	
	@PostMapping("/addScheme")
	public ResponseEntity<Scheme> addScheme(@RequestBody @Valid Scheme scheme) {
		Scheme schemeObj=schemeService.addScheme(scheme);
		ResponseEntity<Scheme> schemes=new ResponseEntity<Scheme> (schemeObj, HttpStatus.OK);
		return schemes; 
	}
	@PutMapping("/updateRateOfInterest/{schemeId}/{rateOfInterest}")
	public ResponseEntity<Scheme> updateRateOfIntrest(@PathVariable long schemeId,@PathVariable double rateOfInterest)throws InvalidEntityException {
		Scheme schemeObj = schemeService.updateRateOfInterest(schemeId,rateOfInterest);
		ResponseEntity<Scheme> schemes= new ResponseEntity<Scheme>(schemeObj, HttpStatus.OK);
		return schemes;
	}
	
	@GetMapping("/viewAllSchemes")
	public ResponseEntity<List<Scheme>> viewAllSchemes() {
		List<Scheme> list = schemeService.viewAllSchemes();
		ResponseEntity<List<Scheme>> schemes=new ResponseEntity<List<Scheme>> (list,HttpStatus.OK);
		return schemes;
	}
	
	
	@GetMapping("/viewSchemeById/{schemeId}")
	public ResponseEntity<Scheme> viewSchemeById(@PathVariable long schemeId) throws InvalidEntityException {
		Scheme schemeObj = schemeService.viewSchemeById(schemeId);
		ResponseEntity<Scheme> schemes=new ResponseEntity<Scheme>(schemeObj,HttpStatus.OK);
		return schemes;
	}
	
	 @GetMapping("/viewSchemeByPolicy/{policyId}")
	 public ResponseEntity<Scheme> viewSchemeByPolicy(@PathVariable long policyId) {
		 Scheme  schemeObj=schemeService.viewSchemeByPolicy(policyId);
		 ResponseEntity<Scheme> schemes=new ResponseEntity<Scheme> (schemeObj,HttpStatus.OK);
		return schemes;
	 }
}
	
	
