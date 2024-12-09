package com.capg.policyapp.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Payment;

public interface PaymentService {
	public Payment addPayment(Payment paymentObj, long policyId) throws InvalidEntityException;
	public Payment updatePaymentStatus(long paymentId, String paymentStatus) throws InvalidEntityException;
	public List<Payment> viewAllPayments();
	public Payment viewPaymentById(long paymentId) throws InvalidEntityException;
	public List<Payment> viewPaymentsOnDate(LocalDate date);
}
