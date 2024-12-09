package com.capg.policyapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.policyapp.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long>{
	
	
}
