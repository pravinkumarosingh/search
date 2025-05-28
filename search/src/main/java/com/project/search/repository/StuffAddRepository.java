package com.project.search.repository;

import com.project.search.model.StuffAddModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StuffAddRepository extends JpaRepository<StuffAddModel, Integer> {
	

	
}
