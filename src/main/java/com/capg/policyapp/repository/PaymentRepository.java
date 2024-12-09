package com.capg.policyapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.policyapp.model.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

	List<Payment> findByPaymentDate(LocalDate paymentDate);

}
