package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Pesticide;
import com.example.demo.model.Crop;

public interface PesticideRepository extends JpaRepository<Pesticide, Integer>{
	
	@Query ("select c from Pesticide c where cropId =:idz")
	//List<Pesticide> findByCropIdsIn(@Param ("idz") List<Integer> cropId);

	List<Pesticide> findByCropIdsIn(@Param ("idz") String cropId);

}
