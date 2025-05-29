package com.project.search.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.search.model.StuffFindModel;

@Repository
public interface StuffFindRepository extends JpaRepository<StuffFindModel, Long> {
	
	
	@Query(value = "SELECT * FROM stuff_data  WHERE name LIKE %:name% " ,nativeQuery=true )
    public StuffFindModel findByName(@Param("name") String name);

	
}
