package com.capg.policyapp.controller;

import java.time.LocalDate;
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
import com.capg.policyapp.model.Payment;
import com.capg.policyapp.service.PaymentService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/addPayment/{policyId}")
	public ResponseEntity<Payment> addPayment(@RequestBody @Valid Payment paymentObj, @PathVariable long policyId)
			throws InvalidEntityException {
		Payment addedPayment = paymentService.addPayment(paymentObj, policyId);
		return new ResponseEntity<>(addedPayment, HttpStatus.CREATED);
	}

	@PutMapping("/updatePaymentStatus/{paymentId}/{paymentStatus}")
	public ResponseEntity<Payment> updatePaymentStatus(@PathVariable long paymentId,
			@PathVariable String paymentStatus) throws InvalidEntityException {
		Payment paymentObj = paymentService.updatePaymentStatus(paymentId, paymentStatus);
		ResponseEntity<Payment> payment = new ResponseEntity<Payment>(paymentObj, HttpStatus.OK);
		return payment;
	}

	@GetMapping("/viewAllPayments")
	public ResponseEntity<List<Payment>> viewAllPayments() {
		List<Payment> list = paymentService.viewAllPayments();
		ResponseEntity<List<Payment>> payment = new ResponseEntity<List<Payment>>(list, HttpStatus.OK);
		return payment;
	}

	@GetMapping("/viewPaymentById/{paymentId}")
	public ResponseEntity<Payment> viewPaymentById(@PathVariable long paymentId) throws InvalidEntityException {
		Payment paymentObj = paymentService.viewPaymentById(paymentId);
		ResponseEntity<Payment> payment = new ResponseEntity<Payment>(paymentObj, HttpStatus.OK);
		return payment;
	}

	@GetMapping("/viewPaymentsOnDate/{date}")
	public ResponseEntity<List<Payment>> viewPaymentsOnDate(@PathVariable LocalDate date) {
		List<Payment> list = paymentService.viewPaymentsOnDate(date);
		ResponseEntity<List<Payment>> payment = new ResponseEntity<List<Payment>>(list, HttpStatus.OK);
		return payment;
	}
}