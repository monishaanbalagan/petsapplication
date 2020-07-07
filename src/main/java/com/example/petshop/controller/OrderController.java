package com.example.petshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshop.dto.OrderRequestDto;
import com.example.petshop.dto.OrderResponseDto;
import com.example.petshop.dto.OrdersDetailsListResponseDto;
import com.example.petshop.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	/**
	 * @param userId
	 * @param orderRequestDto
	 * @return
	 */
	@PostMapping("/users/{userId}/orders")
	public ResponseEntity<OrderResponseDto> orderPets(@PathVariable("userId")int userId,OrderRequestDto orderRequestDto) {

		OrderResponseDto orderResponseDto = orderService.orderPetsByPetId(userId,orderRequestDto.getPetId());

		return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);

	}
	/**
	 * @param userId
	 * @return 
	 */
	@PostMapping("/users/{userId}/ordersList")
	public ResponseEntity<OrdersDetailsListResponseDto> getOrdersList(@PathVariable("userId")int userId) {

		OrdersDetailsListResponseDto ordersListDetails = orderService.getOrdersListByUserId(userId);

		return new ResponseEntity<>(ordersListDetails, HttpStatus.OK);

	}

}
