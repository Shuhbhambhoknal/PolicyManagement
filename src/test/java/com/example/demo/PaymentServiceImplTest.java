package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capg.policyapp.controller.PaymentController;
import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Payment;
import com.capg.policyapp.service.PaymentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {

    @Mock
    PaymentServiceImpl paymentService;

    @InjectMocks
    PaymentController paymentController;

    @Test
    void testAddPayment() throws InvalidEntityException {
        Payment payment = new Payment();

        when(paymentService.addPayment(payment, 123)).thenReturn(payment);

        ResponseEntity<Payment> response = paymentController.addPayment(payment, 123);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(payment, response.getBody());
    }

    @Test
    void testUpdatePaymentStatus() throws InvalidEntityException {
        long paymentId = 123;
        String paymentStatus = "Paid";
        Payment updatedPayment = new Payment();
        updatedPayment.setPaymentId(paymentId);
        updatedPayment.setPaymentStatus(paymentStatus);
        when(paymentService.updatePaymentStatus(paymentId, paymentStatus)).thenReturn(updatedPayment);

        ResponseEntity<Payment> response = paymentController.updatePaymentStatus(paymentId, paymentStatus);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedPayment, response.getBody());
    }

}
