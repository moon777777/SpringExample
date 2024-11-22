package com.bbar.spring.ex.jpa.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 객체를 생성하는 또 다른 방법
@Builder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="`new_student`")
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name="phoneNumber")
	private String phoneNumer;
	private String email;
	@Column(name="dreamJob")
	private String dreamJob;
	
	@Column(name="createdAt")
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(name="updatedAt")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	

}
