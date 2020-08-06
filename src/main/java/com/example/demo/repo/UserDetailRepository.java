package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.model.User;
import com.example.demo.model.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer>{

	//public UserDetail findUserName(String userName);
	@Query ("select c from UserDetail c where userid in :userid")
	UserDetail findUserId(@Param ("userid") int userId);
}
