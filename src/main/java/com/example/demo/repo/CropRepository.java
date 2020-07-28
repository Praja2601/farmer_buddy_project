package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Crop;
import com.example.demo.model.CropType;

public interface CropRepository extends JpaRepository<Crop, Integer>{

	//public List<Crop> getCropsDetails(String cropTypeId);
	@Query ("select c from Crop c where cropTypeId in :id")
	List<Crop> findByCropTypeIdsIn(@Param ("id") String cropTypeId);
}
