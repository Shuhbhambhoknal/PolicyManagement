package com.capg.policyapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.policyapp.dao.PaymentDAO;
import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDAO PayDAO;

	@Override
	public Payment addPayment(Payment paymentObj, long policyId)throws InvalidEntityException {
		return PayDAO.addPayment(paymentObj, policyId);
	}

	@Override
	public Payment updatePaymentStatus(long paymentId, String paymentStatus)throws InvalidEntityException {
		return PayDAO.updatePaymentStatus(paymentId, paymentStatus);
	}

	@Override
	public List<Payment> viewAllPayments() {
		return PayDAO.viewAllPayments();
	}

	@Override
	public Payment viewPaymentById(long paymentId) throws InvalidEntityException {
		return PayDAO.viewPaymentById(paymentId);
	}

	@Override
	public List<Payment> viewPaymentsOnDate(LocalDate date) {
		return PayDAO.viewPaymentsOnDate(date);
	}

	

}
