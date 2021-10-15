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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamreact.model.ClassDTO;
import com.teamreact.model.ResponseDTO;
import com.teamreact.service.ClassService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = -1)
public class ClassController {
	@Autowired
	private ClassService classService;

	@PostMapping("/classes")
	public ClassDTO add(@RequestBody ClassDTO classDTO) {
		classService.add(classDTO);
		return classDTO;
	}

	@PutMapping(value = "/classes/{id}")
	public ClassDTO update(@RequestBody ClassDTO classDTO ,@PathVariable(name = "id") int id) {
		classDTO.setId(id);
		classService.update(classDTO);
		return classDTO;
	}

	@DeleteMapping(value = "/classes/{id}")
	public void delete(@PathVariable(name = "id") int id) {
		classService.delete(id);
	}

	@GetMapping(value = "/classes/{id}")
	public ClassDTO get(@PathVariable(name = "id") int id) {
		return classService.get(id);
	}

	@GetMapping(value = "/classes")
	public ResponseDTO<ClassDTO> find(@RequestParam(name = "search", required = true) String search,
			@RequestParam(name = "page", required = true) int page,
			@RequestParam(name = "limit", required = true) int limit) {
		ResponseDTO<ClassDTO> responseDTO = new ResponseDTO<ClassDTO>();
		responseDTO.setData(classService.search(search, page, limit));
		responseDTO.setRecordsFiltered(classService.countSearch(search, page, limit));
		responseDTO.setRecordsTotal(classService.countTotal());
		return responseDTO;
	}
}