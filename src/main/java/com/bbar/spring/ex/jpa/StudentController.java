package com.bbar.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbar.spring.ex.jpa.domain.Student;
import com.bbar.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	// create, update, delete
	
	// 한 학생의 정보 저장 기능
	@ResponseBody
	@GetMapping("/create")
	public Student createStudent() {
		// 김인규, 010-1234-5678, lecture@hangulu.com, 개발자
		Student student = studentService.addStudet("김인규", "010-1234-5678", "lecture@hagulu.com", "개발자");
		
		return student;
	}
	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		// id 가 3인 장래희망을 강사로 변경
		Student student =  studentService.updateStudent(4, "강사");
		
		return student;
	}
	@ResponseBody
	@GetMapping("/delete")
	public String deleteStudent() {
		// id가 3인 정보 삭제
		studentService.deleteStudent(3);
		
		return "삭제";
	}
	
	@GetMapping("/lombok")
	@ResponseBody
	public Student lombokTest() {
		
//		Student student = new Student(1, "김인규", "010-1234-5678", "lecture@hagulu.com", "개발자", null, null);
		
		// builder 패턴
		Student student = Student.builder()
				.name("김인규")
				.email("lecture@hagulu.com")
				.phoneNumer("010-1234-5678")
				.build();
		
		return student;
	}
}
