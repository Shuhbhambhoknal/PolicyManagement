
package com.capg.policyapp.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "claim")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)		
    private long claimId;
    
    @NotNull(message = "Provide a valid value for dateOfClaim")
    private LocalDate dateOfClaim;
    private String claimDescription;
    
    @Pattern(regexp = "^(pending|paid|rejected)$", message = "Provide a correct claim status")
    private String claimStatus;
    
    @Min(value = 10000, message = "Provide a valid value for claimAmount")
    private double claimAmount;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    @JsonBackReference("policy")
    private Policy policy;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference("customer")
    private Customer customer;

	public Claim() {
		super();
	}

	public long getClaimId() {
		return claimId;
	}

	public void setClaimId(long claimId) {
		this.claimId = claimId;
	}

	public LocalDate getDateOfClaim() {
		return dateOfClaim;
	}

	public void setDateOfClaim(LocalDate dateOfClaim) {
		this.dateOfClaim = dateOfClaim;
	}

	public String getClaimDescription() {
		return claimDescription;
	}

	public void setClaimDescription(String claimDescription) {
		this.claimDescription = claimDescription;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
	this.customer = customer;
	}

	public Claim(long claimId, LocalDate dateOfClaim, String claimDescription, String claimStatus, double claimAmount,
			Policy policy, Customer customer) {
		super();
		this.claimId = claimId;
		this.dateOfClaim = dateOfClaim;
		this.claimDescription = claimDescription;
		this.claimStatus = claimStatus;
		this.claimAmount = claimAmount;
		this.policy = policy;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", dateOfClaim=" + dateOfClaim + ", claimDescription=" + claimDescription
				+ ", claimStatus=" + claimStatus + ", claimAmount=" + claimAmount + ", policy=" + policy + ", customer="
				+ customer + "]";
	}

	
}
