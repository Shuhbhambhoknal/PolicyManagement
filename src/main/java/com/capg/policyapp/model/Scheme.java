package com.capg.policyapp.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name = "scheme")
public class Scheme {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long schemeId;
	
	@NotBlank(message = "Provide a value for scheme name")
	private String schemeName;
	
	@Min(value = 1, message = "Provide a valid minimum year")
    @Max(value = 5, message = "Provide a valid minimum year")
	private int minimumYear;
	
	@Min(value = 10, message = "Provide a valid maximum year")
    @Max(value = 60, message = "Provide a valid maximum year")
	private int maximumYear;
	
	@Positive(message = "Provide a valid minimum premium amount")
	private double minimumPremiumAmount;
	
	@Positive(message = "Provide a valid rate of interest")
	private double rateOfInterest;
	
	@OneToMany(mappedBy = "scheme", cascade = CascadeType.ALL)
	private List<Policy> policyList;
	
	public Scheme() {
		super();
	}
	public Scheme(long schemeId, String schemeName, int minimumYear, int maximumYear, double minimumPremiumAmount,
			double rateOfInterest, List<Policy> policyList) {
		super();
		this.schemeId = schemeId;
		this.schemeName = schemeName;
		this.minimumYear = minimumYear;
		this.maximumYear = maximumYear;
		this.minimumPremiumAmount = minimumPremiumAmount;
		this.rateOfInterest = rateOfInterest;
		this.policyList = policyList;
	}
	public long getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(long schemeId) {
		this.schemeId = schemeId;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public int getMinimumYear() {
		return minimumYear;
	}
	public void setMinimumYear(int minimumYear) {
		this.minimumYear = minimumYear;
	}
	public int getMaximumYear() {
		return maximumYear;
	}
	public void setMaximumYear(int maximumYear) {
		this.maximumYear = maximumYear;
	}
	public double getMinimumPremiumAmount() {
		return minimumPremiumAmount;
	}
	public void setMinimumPremiumAmount(double minimumPremiumAmount) {
		this.minimumPremiumAmount = minimumPremiumAmount;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfIntrest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public List<Policy> getPolicyList() {
		return policyList;
	}
	public void setPolicyList(List<Policy> policyList) {
		this.policyList = policyList;
	}
	@Override
	public String toString() {
		return "Scheme [schemeId=" + schemeId + ", schemeName=" + schemeName + ", minimumYear=" + minimumYear
				+ ", maximumYear=" + maximumYear + ", minimumPremiumAmount=" + minimumPremiumAmount + ", rateOfInterest="
				+ rateOfInterest + ", policyList=" + policyList + "]";
	}	
}