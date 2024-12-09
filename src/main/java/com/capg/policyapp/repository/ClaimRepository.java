package com.capg.policyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.policyapp.model.Claim;
@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
	
}
