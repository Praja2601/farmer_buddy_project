package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Crop;

public interface FertilizerRepository extends JpaRepository<Crop, Integer>{
	
	@Query ("select c from Crop c where cropId in :id")
	List<Crop> findByCropIdsIn(@Param ("id") int cropId);
	
}
