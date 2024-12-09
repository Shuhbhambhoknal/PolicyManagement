package com.capg.policyapp.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "policy")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long policyId;
	
	@NotNull(message = "Provide a valid value for policy startDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@DecimalMin(value = "1000.0", message = "Provide a valid value for policy totalPremiumAmount")
	@Positive(message = "Provide a valid value for policy totalPremiumAmount")
	private double totalPremiumAmount;
	
	@NotNull(message = "Provide a value for policy maturityAmount")
	private double maturityAmount;
	
	@Positive(message = "Provide a valid Policy number of years")
	private int numberOfYears;
	
	@Pattern(regexp = "^(active|inactive|closed)$", message = "Provide a correct policy status")
	private String policyStatus;
	
	@NotNull(message = "Provide a valid value for policy closureDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate closureDate;
	
	@Pattern(regexp = "^(quarterly|half-yearly|annual|one-time)$", message = "Provide a correct annuity term")
	private String annuityTerm;

	@ManyToOne
	@JoinColumn(name = "scheme_id")
	@JsonBackReference("scheme")
	private Scheme scheme;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonBackReference("customer")
	private Customer customer;

	@OneToMany(mappedBy = "policy",cascade = CascadeType.ALL)
	@JsonBackReference("paymentList")
	private List<Payment> paymentList;

	@OneToMany(mappedBy = "policy",cascade = CascadeType.ALL)
	private List<Claim> claimList;
	

	public Policy() {
		super();
	}

	public long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public double getTotalPremiumAmount() {
		return totalPremiumAmount;
	}

	public void setTotalPremiumAmount(double totalPremiumAmount) {
		this.totalPremiumAmount = totalPremiumAmount;
	}

	public double getMaturityAmount() {
		return maturityAmount;
	}

	public void setMaturityAmount(double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}

	public int getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public LocalDate getClosureDate() {
		return closureDate;
	}

	public void setClosureDate(LocalDate closureDate) {
		this.closureDate = closureDate;
	}

	public String getAnnuityTerm() {
		return annuityTerm;
	}

	public void setAnnuityTerm(String annuityTerm) {
		this.annuityTerm = annuityTerm;
	}

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public List<Claim> getClaimList() {
		return claimList;
	}

	public void setClaimList(List<Claim> claimList) {
		this.claimList = claimList;
	}

	public Policy(long policyId, LocalDate startDate, double totalPremiumAmount, double maturityAmount,
			int numberOfYears, String policyStatus, LocalDate closureDate, String annuityTerm, Scheme scheme,
			Customer customer, List<Payment> paymentList, List<Claim> claimList) {
		super();
		this.policyId = policyId;
		this.startDate = startDate;
		this.totalPremiumAmount = totalPremiumAmount;
		this.maturityAmount = maturityAmount;
		this.numberOfYears = numberOfYears;
		this.policyStatus = policyStatus;
		this.closureDate = closureDate;
		this.annuityTerm = annuityTerm;
		this.scheme = scheme;
		this.customer = customer;
		this.paymentList = paymentList;
		this.claimList = claimList;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", startDate=" + startDate + ", totalPremiumAmount="
				+ totalPremiumAmount + ", maturityAmount=" + maturityAmount + ", numberOfYears=" + numberOfYears
				+ ", policyStatus=" + policyStatus + ", closureDate=" + closureDate + ", annuityTerm=" + annuityTerm
				+ ", scheme=" + scheme + ", customer=" + customer+ ", paymentList=" + paymentList
				+ ", claimList=" + claimList + "]";
	}

}
