package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.CropType;

public interface CropTypeRepository extends JpaRepository<CropType, Integer>{
@Query ("select c from CropType c where cropTypeId in :ids")
List<CropType> findByCropTypeIdsIn(@Param ("ids") List<Integer> cropTypeId);
}
