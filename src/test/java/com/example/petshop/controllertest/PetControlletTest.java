package com.example.petshop.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.petshop.controller.PetController;
import com.example.petshop.dto.PetListResponseDto;
import com.example.petshop.service.PetService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class PetControlletTest {
	@Mock
	PetService petService;

	MockMvc mockMvc;
	ObjectMapper objectMapper;

	@InjectMocks
	PetController petController;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(petController).build();

	}

	@Test
	public void getBooksByAuthorNameAndBookTitleTest() throws Exception {
		
	PetListResponseDto petListResponseDto = new PetListResponseDto();
	petListResponseDto.setMessage("Please find the list of available books");
	petListResponseDto.setStatusCode(200);

	Mockito.when(petService.getPetsByPetName("petName")).thenReturn(petListResponseDto);

	 

    ResponseEntity<PetListResponseDto> petDetailsResponse = petController.searchPets("petName");
    assertEquals(HttpStatus.OK, petDetailsResponse.getStatusCode());


	}

}
