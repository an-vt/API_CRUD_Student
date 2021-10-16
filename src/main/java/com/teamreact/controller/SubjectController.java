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

import com.teamreact.model.ResponseDTO;
import com.teamreact.model.SubjectDTO;
import com.teamreact.service.SubjectService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = -1)
public class SubjectController {
	@Autowired
	private SubjectService subjectService;

	@PostMapping("/subjects")
	public SubjectDTO add(@RequestBody SubjectDTO subjectDTO) {
		subjectService.add(subjectDTO);
		return subjectDTO;
	}

	@PutMapping(value = "/subjects/{id}")
	public SubjectDTO update(@RequestBody SubjectDTO subjectDTO ,@PathVariable(name = "id") int id) {
		subjectDTO.setId(id);
		subjectService.update(subjectDTO);
		return subjectDTO;
	}

	@DeleteMapping(value = "/subjects/{id}")
	public void delete(@PathVariable(name = "id") int id) {
		subjectService.delete(id);
	}

	@GetMapping(value = "/subjects/{id}")
	public SubjectDTO get(@PathVariable(name = "id") int id) {
		return subjectService.get(id);
	}

	@GetMapping(value = "/subjects")
	public ResponseDTO<SubjectDTO> find(@RequestParam(name = "search", required = true) String search,
			@RequestParam(name = "page", required = true) int page,
			@RequestParam(name = "limit", required = true) int limit) {
		ResponseDTO<SubjectDTO> responseDTO = new ResponseDTO<SubjectDTO>();
		responseDTO.setData(subjectService.search(search, page, limit));
		responseDTO.setRecordsFiltered(subjectService.countSearch(search, page, limit));
		responseDTO.setRecordsTotal(subjectService.countTotal());
		return responseDTO;
	}
}