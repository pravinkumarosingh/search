package com.project.search.repository;

import com.project.search.model.StuffAddModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface StuffFindRepository extends JpaRepository<StuffAddModel, Integer> {
	
	@Query(value = "SELECT * FROM stuff_data s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :pattern, '%'))" , nativeQuery=true)
	StuffAddModel findStuffByNameLike(@Param("pattern") String pattern);
	
}
