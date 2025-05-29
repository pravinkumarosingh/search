package com.project.search.repository;

import com.project.search.model.StuffAddModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface StuffAddRepository extends JpaRepository<StuffAddModel, Integer> {
	
	@Modifying
	@Query(value = "UPDATE stuff_data SET location=:location WHERE name LIKE %:name%" , nativeQuery=true)
	public void updateStuffDetails(@Param("name") String name, @Param("location") String location);
	
}
