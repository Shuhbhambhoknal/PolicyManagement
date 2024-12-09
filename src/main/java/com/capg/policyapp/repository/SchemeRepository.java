package com.capg.policyapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.policyapp.model.Scheme;

public interface SchemeRepository  extends JpaRepository<Scheme ,Long>{

	
}


