package com.teamreact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamreact.model.ResponseDTO;
import com.teamreact.model.SearchDTO;
import com.teamreact.model.ClassDTO;
import com.teamreact.service.ClassService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = -1)
public class ClassController {
	@Autowired
	private ClassService classService;

	@PostMapping("/classs")
	public ClassDTO add(@RequestBody ClassDTO classDTO) {
		classService.add(classDTO);
		return classDTO;
	}

	@PutMapping(value = "/classs/{id}")
	public ClassDTO update(@RequestBody ClassDTO classDTO ,@PathVariable(name = "id") int id) {
		classDTO.setId(id);
		classService.update(classDTO);
		return classDTO;
	}

	@DeleteMapping(value = "/classs/{id}")
	public void delete(@PathVariable(name = "id") int id) {
		classService.delete(id);
	}

	@GetMapping(value = "/classs/{id}")
	public ClassDTO get(@PathVariable(name = "id") int id) {
		return classService.get(id);
	}

	@PostMapping(value = "/classs/search")
	public ResponseDTO<ClassDTO> find(@RequestBody SearchDTO searchDTO) {
		ResponseDTO<ClassDTO> responseDTO = new ResponseDTO<ClassDTO>();
		responseDTO.setData(classService.search(searchDTO));
		responseDTO.setRecordsFiltered(classService.countSearch(searchDTO));
		responseDTO.setRecordsTotal(classService.countTotal(searchDTO));
		return responseDTO;
	}
}