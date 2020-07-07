package com.example.petshop.dto;

import java.util.List;



public class PetListResponseDto {
	private String message;
	private int statusCode;
	List<PetDetailsResponseDto> petDetailsResponseDto;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<PetDetailsResponseDto> getPetDetailsResponseDto() {
		return petDetailsResponseDto;
	}
	public void setPetDetailsResponseDto(List<PetDetailsResponseDto> petDetailsResponseDto) {
		this.petDetailsResponseDto = petDetailsResponseDto;
	}
	
	
	
}
