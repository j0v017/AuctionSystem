package com.wells.qart.eAuction.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.wells.qart.eAuction.dto.InterestsDto;
import com.wells.qart.eAuction.service.InterestsService;

@RestController
@RequestMapping("/interests")
public class InterestsRestController {

	@Autowired
	private InterestsService interestsService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addInterests(@Valid @RequestBody InterestsDto interestsDto, BindingResult result) {
		interestsService.createInterest(interestsDto);
		return new ResponseEntity<InterestsDto>(interestsDto, HttpStatus.OK);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateInterests(@Valid @RequestBody InterestsDto interestsDto, BindingResult result) {
		interestsService.updateInterest(interestsDto);
		return new ResponseEntity<InterestsDto>(interestsDto, HttpStatus.OK);
	}

	@DeleteMapping("/{interestId}")
	public boolean deleteInterests(@PathVariable Long interestId) {
		interestsService.deleteInterest(interestId);
		return true;
	}

	@GetMapping("/{interestId}")
	public ResponseEntity<InterestsDto> getInterestsById(@PathVariable Long interestId) {
		InterestsDto interestsDto = interestsService.getById(interestId);

		return new ResponseEntity<InterestsDto>(interestsDto, HttpStatus.OK);
	}

	@GetMapping("/by-user-id/{userId}")
	public ResponseEntity<List<InterestsDto>> getInterestsByUserId(@PathVariable Long userId) {
		List<InterestsDto> interestsDtos = interestsService.getInterestsByUserId(userId);
		return new ResponseEntity<List<InterestsDto>>(interestsDtos, HttpStatus.OK);
	}

}