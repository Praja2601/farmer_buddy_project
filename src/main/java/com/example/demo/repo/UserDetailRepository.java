package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer>{

}
