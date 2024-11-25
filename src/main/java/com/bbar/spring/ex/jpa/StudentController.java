package com.bbar.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbar.spring.ex.jpa.domain.Student;
import com.bbar.spring.ex.jpa.repository.StudentRepository;
import com.bbar.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	// create, update, delete
	
	// 사실 컨트롤러에서 repository를 끌어다 쓰면 안됨 그냥 편의를 위해서 쓰는거지 절대 이런 방식을 사용하지 말것!!!!
	@Autowired
	private StudentRepository studentRepository;
	
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
	@ResponseBody
	@GetMapping("/find")
	public List<Student> findStudent() {
		
		List<Student> studentList = null;
		
		// 모든 행 조회
//		List<Student> studentList = studentRepository.findAll();
		
		// 모든 행을 id 컬럼 내림 차순으로 조회
//		studentList = studentRepository.findAllByOrderByIdDesc();
		
//		studentList = studentRepository.findTop2ByOrderByIdDesc();
		
//		studentList = studentRepository.findByName("김인규");
		
		List<String> nameList = new ArrayList<>();
		nameList.add("유재석");
		nameList.add("조세호");
		
//		studentList = studentRepository.findByNameIn(nameList);
		
//		studentList = studentRepository.findByEmailContaining("gmail");
		
		
//		studentList = studentRepository.findByIdBetweenOrderByIdDesc(1, 3);
		
		studentList = studentRepository.selectByDreamJob("모델");
		return studentList;
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
