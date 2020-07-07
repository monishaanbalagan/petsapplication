package com.example.petshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshop.dto.PetListResponseDto;
import com.example.petshop.service.PetService;

@RestController
public class PetController {
	@Autowired
	PetService petService;

	/**
	 * @param petName
	 * @return
	 */
	@GetMapping("/pet")
	public ResponseEntity<PetListResponseDto> searchPets(@RequestParam("petName") String petName) {

		PetListResponseDto petDetailsResponse = petService.getPetsByPetName(petName);

		return new ResponseEntity<PetListResponseDto>(petDetailsResponse, HttpStatus.OK);

	}

}
