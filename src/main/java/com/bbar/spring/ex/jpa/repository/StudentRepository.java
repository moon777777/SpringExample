package com.bbar.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbar.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
}
