package com.example.petshop.service;

import com.example.petshop.dto.PetListResponseDto;

public interface PetService {

	PetListResponseDto getPetsByPetName(String petName);

}
