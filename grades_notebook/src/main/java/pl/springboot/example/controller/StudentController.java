package pl.springboot.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.springboot.example.exception.ResourceNotFoundException;
import pl.springboot.example.model.Student;
import pl.springboot.example.repository.StudentRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
	@Autowired
	private StudentRepository StudentRepository;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return StudentRepository.findAll();
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long StudentId)
			throws ResourceNotFoundException {
		Student Student = StudentRepository.findById(StudentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + StudentId));
		return ResponseEntity.ok().body(Student);
	}

	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student Student) {
		return StudentRepository.save(Student);
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long StudentId,
			@Valid @RequestBody Student StudentDetails) throws ResourceNotFoundException {
		Student Student = StudentRepository.findById(StudentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + StudentId));


		Student.setLastName(StudentDetails.getLastName());
		Student.setFirstName(StudentDetails.getFirstName());
		Student.setClassName(StudentDetails.getClassName());
		final Student updatedStudent = StudentRepository.save(Student);
		return ResponseEntity.ok(updatedStudent);
	}

	@DeleteMapping("/students/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long StudentId)
			throws ResourceNotFoundException {
		Student Student = StudentRepository.findById(StudentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + StudentId));

		StudentRepository.delete(Student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
