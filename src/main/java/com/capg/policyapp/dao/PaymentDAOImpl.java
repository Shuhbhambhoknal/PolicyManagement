package com.capg.policyapp.dao;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Payment;
import com.capg.policyapp.model.Policy;
import com.capg.policyapp.repository.PaymentRepository;
import com.capg.policyapp.repository.PolicyRepository;

@Service
public class PaymentDAOImpl implements PaymentDAO {

	  @Autowired
    private PaymentRepository paymentRepository;
	  @Autowired
	private PolicyRepository policyRepository;

    @Override
    public Payment addPayment(Payment paymentObj, long policyId) throws InvalidEntityException {
        Optional<Policy> optionalPolicy = policyRepository.findById(policyId);
        if (optionalPolicy.isPresent()) {
            Policy policy = optionalPolicy.get();
            paymentObj.setPolicy(policy);
            Payment payment = paymentRepository.saveAndFlush(paymentObj);
            return payment;
        } else {
            throw new InvalidEntityException("Policy not found with ID: " + policyId);
        }
    }

    @Override
    public Payment updatePaymentStatus(long paymentId, String paymentStatus) throws InvalidEntityException {
        Optional<Payment> opPayment = paymentRepository.findById(paymentId);
        if (opPayment.isPresent()) {
            Payment payment = opPayment.get();
            payment.setPaymentStatus(paymentStatus);
            paymentRepository.saveAndFlush(payment);
            return payment;
        } else {
            throw new InvalidEntityException("Payment not found with ID: " + paymentId);
        }
    }

    @Override
    public List<Payment> viewAllPayments() {
        List<Payment> paymentList = paymentRepository.findAll();
        return paymentList;
    }

    @Override
    public Payment viewPaymentById(long paymentId) throws InvalidEntityException {
        Optional<Payment> opPayment = paymentRepository.findById(paymentId);
        if (opPayment.isPresent()) {
            return opPayment.get();
        } else {
            throw new InvalidEntityException("Payment not found with ID: " + paymentId);
        }
    }

    @Override
	public List<Payment> viewPaymentsOnDate(LocalDate paymentDate) {
		List<Payment> payments = paymentRepository.findByPaymentDate(paymentDate);
		return payments;
	}
}