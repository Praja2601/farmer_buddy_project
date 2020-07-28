package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ContactDetail;

public interface ContactUsRepository extends JpaRepository<ContactDetail, Integer>{

}
