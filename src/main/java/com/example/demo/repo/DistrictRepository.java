package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.District;

public interface DistrictRepository extends JpaRepository<District, Integer>{

}
