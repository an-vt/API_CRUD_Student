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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teamreact.model.ResponseDTO;
import com.teamreact.model.SearchDTO;
import com.teamreact.model.StudentDTO;
import com.teamreact.service.StudentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = -1)
public class StudentController {
	@Autowired
	private StudentService studentService;

//	@RequestMapping(value = "/students", headers = "Accept=application/json", method = RequestMethod.POST)
	@PostMapping(value = "/students")
	public StudentDTO add(@RequestBody StudentDTO studentDTO) {
		System.out.println("addd student");
		System.out.println(studentDTO.getAge()+studentDTO.getName());
		System.out.println(studentDTO.getClassDTO().getId());
		studentService.add(studentDTO); 
		return studentDTO;
	}

	@PutMapping(value = "/students/{id}")
	public StudentDTO update(@RequestBody StudentDTO studentDTO ,@PathVariable(name = "id") int id) {
		studentDTO.setId(id);
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

	@PostMapping(value = "/students/search")
	public ResponseDTO<StudentDTO> find(@RequestBody SearchDTO searchDTO) {
		ResponseDTO<StudentDTO> responseDTO = new ResponseDTO<StudentDTO>();
		responseDTO.setData(studentService.search(searchDTO));
		responseDTO.setRecordsFiltered(studentService.countSearch(searchDTO));
		responseDTO.setRecordsTotal(studentService.countTotal(searchDTO));
		return responseDTO;
	}
}