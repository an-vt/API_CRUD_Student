package com.teamreact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamreact.model.ResponseDTO;
import com.teamreact.model.StudentDTO;
import com.teamreact.service.ClassService;
import com.teamreact.service.StudentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = -1)
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassService classService;

	@PostMapping(value = "/students")
	public StudentDTO add(@RequestBody StudentDTO studentDTO) {		
//	public StudentDTO add(@ModelAttribute StudentDTO studentDTO) {		
		studentService.add(studentDTO);
//		System.out.println(DateTimeUtils.parseDate(studentDTO.getdOB(), DateTimeUtils.DD_MM_YYYY));
		return studentDTO;
	}

	@PutMapping(value = "/students/{id}")
	public StudentDTO update(@RequestBody StudentDTO studentDTO) {
		System.out.println(studentDTO.getdOB()+studentDTO.getId());
		studentService.update(studentDTO);
		return studentDTO;
	}

	@DeleteMapping(value = "/students/{id}")
	public void delete(@PathVariable(name = "id") int id) {
		studentService.delete(id);
	}

	@GetMapping(value = "/students/{id}")
	public StudentDTO get(@PathVariable(name = "id") int id) {
		return studentService.get(id);
	}

	@GetMapping(value = "/students")
	public ResponseDTO<StudentDTO> find(@RequestParam(name = "search", required = true) String search,
			@RequestParam(name = "page", required = true) int page,
			@RequestParam(name = "limit", required = true) int limit) {
		ResponseDTO<StudentDTO> responseDTO = new ResponseDTO<StudentDTO>();
		responseDTO.setData(studentService.search(search, page, limit));
		responseDTO.setRecordsFiltered(studentService.countSearch(search, page, limit));
		responseDTO.setRecordsTotal(studentService.countTotal());
		return responseDTO;
	}
}