package com.capg.policyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.policyapp.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	 
}
