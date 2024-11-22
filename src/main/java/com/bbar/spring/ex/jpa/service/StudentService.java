package com.bbar.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbar.spring.ex.jpa.domain.Student;
import com.bbar.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudet(String name, String phobeNumber, String email, String dreamJob) {
		
		Student student = Student.builder()
				.name(name)
				.phoneNumer(phobeNumber)
				.email(email)
				.dreamJob(dreamJob)
				.build();
		
		Student result =  studentRepository.save(student);
		
		return result;
	}
	
	public Student updateStudent(int id, String dreamJob) {
		// update 대상을 조회한다.
		// 조회된 결과 객체를 얻어온다.
		// 조회된 객체에서 수정사항을 적용한다.
		// 수정된 객체를 저장한다.
		
		// Optional 객체
		// null 일 수도 있는 객체를 null을 처리하는 기능으로 감싸놓은 객체
		// null 을 다룰때 발생될 수 있는 NullPointerException 위험없이 처리하도록 도와준다.
		// null일수도 있는 객체를 리턴하는 메소드에서 리턴타입으로 주로 사용
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		Student student = optionalStudent.orElse(null);
		
		student = student.toBuilder().dreamJob(dreamJob).build();
		
		Student result =  studentRepository.save(student);
		
		return result;
		// 이거 강사님은 student로 리턴 했는데 나옴
		
	}
	
	public void deleteStudent(int id) {
		// 삭제 대상을 조회 한다.
		// 조회된 객체를 통해 삭제한다.
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		Student student = optionalStudent.orElse(null);
		
		studentRepository.delete(student);
	}
}
