package com.project.search.repository;

import com.project.search.model.StuffModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffFindRepository extends JpaRepository<StuffModel, Integer> {

}
