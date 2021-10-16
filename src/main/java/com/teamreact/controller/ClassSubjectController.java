package com.teamreact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamreact.model.ClassSubjectDTO;
import com.teamreact.model.ResponseDTO;
import com.teamreact.service.ClassSubjectService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = -1)
public class ClassSubjectController {
	@Autowired
	private ClassSubjectService classSubjectService;

	@PostMapping("/class_subject")
	public ClassSubjectDTO add(@RequestBody ClassSubjectDTO classSubjectDTO) {
		classSubjectService.add(classSubjectDTO);
		return classSubjectDTO;
	}

	@GetMapping("/class_subject")
	public ResponseDTO<ClassSubjectDTO> findByStudentId(@RequestParam(name = "classId", required = true) long classId,
			@RequestParam(name = "page", required = true) int page,
			@RequestParam(name = "limit", required = true) int limit) {
		ResponseDTO<ClassSubjectDTO> responseDTO = new ResponseDTO<ClassSubjectDTO>();
		responseDTO.setData(classSubjectService.findByClassId(classId, page, limit));
		responseDTO.setRecordsFiltered(classSubjectService.countSearch(classId, page, limit));
		responseDTO.setRecordsTotal(classSubjectService.countTotal());
		return responseDTO;
	}
}