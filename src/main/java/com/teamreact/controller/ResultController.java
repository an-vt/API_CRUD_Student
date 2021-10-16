package com.teamreact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamreact.model.ResponseDTO;
import com.teamreact.model.ResultDTO;
import com.teamreact.service.ResultService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = -1)
public class ResultController {
	@Autowired
	private ResultService resultService;

	@PostMapping("/results")
	public ResultDTO add(@RequestBody ResultDTO resultDTO) {
		resultService.add(resultDTO);
		return resultDTO;
	}
	
	@GetMapping("/results")
	public ResponseDTO<ResultDTO> findByStudentId(@RequestParam(name = "studentId", required = true) long studentId,
			@RequestParam(name = "page", required = true) int page,
			@RequestParam(name = "limit", required = true) int limit) {
		ResponseDTO<ResultDTO> responseDTO = new ResponseDTO<ResultDTO>();
		responseDTO.setData(resultService.findByStudentId(studentId, page, limit));
		responseDTO.setRecordsFiltered(resultService.countFindByStudentId(studentId, page, limit));
		responseDTO.setRecordsTotal(resultService.countTotal());
		return responseDTO;
	}

//	@PutMapping(value = "/subjects/{id}")
//	public SubjectDTO update(@RequestBody SubjectDTO subjectDTO ,@PathVariable(name = "id") int id) {
//		subjectDTO.setId(id);
//		subjectService.update(subjectDTO);
//		return subjectDTO;
//	}
}