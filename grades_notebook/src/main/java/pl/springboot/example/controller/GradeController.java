package pl.springboot.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.springboot.example.exception.ResourceNotFoundException;
import pl.springboot.example.model.Grade;
import pl.springboot.example.model.Student;
import pl.springboot.example.repository.GradeRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class GradeController {
	@Autowired
	private GradeRepository GradeRepository;

	@GetMapping("/grades")
	public List<Grade> getAllGrades() {
		return GradeRepository.findAll();
	}

	@GetMapping("/grades/{id}")
	public ResponseEntity<Grade> getGradeById(@PathVariable(value = "id") Long GradeId)
			throws ResourceNotFoundException {
		Grade Grade = GradeRepository.findById(GradeId)
				.orElseThrow(() -> new ResourceNotFoundException("Grade not found for this id :: " + GradeId));
		return ResponseEntity.ok().body(Grade);
	}

	@GetMapping("/grades/bystudent/{id}")
	public List<Grade> getGradeByStudentId(@PathVariable(value = "id") Student StudentId)
			throws ResourceNotFoundException {
		return GradeRepository.findByStudentId(StudentId);
	}

	@PostMapping("/grades")
	public Grade createGrade(@Valid @RequestBody Grade Grade) {
		return GradeRepository.save(Grade);
	}

	@PutMapping("/grades/{id}")
	public ResponseEntity<Grade> updateGrade(@PathVariable(value = "id") Long GradeId,
			@Valid @RequestBody Grade GradeDetails) throws ResourceNotFoundException {
		Grade Grade = GradeRepository.findById(GradeId)
				.orElseThrow(() -> new ResourceNotFoundException("Grade not found for this id :: " + GradeId));


		Grade.setGrade(GradeDetails.getGrade());
		Grade.setNote(GradeDetails.getNote());
		Grade.setStudentId(GradeDetails.getStudentId());
		Grade.setSubjectId(GradeDetails.getSubjectId());
		final Grade updatedGrade = GradeRepository.save(Grade);
		return ResponseEntity.ok(updatedGrade);
	}

	@DeleteMapping("/grades/{id}")
	public Map<String, Boolean> deleteGrade(@PathVariable(value = "id") Long GradeId)
			throws ResourceNotFoundException {
		Grade Grade = GradeRepository.findById(GradeId)
				.orElseThrow(() -> new ResourceNotFoundException("Grade not found for this id :: " + GradeId));

		GradeRepository.delete(Grade);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
