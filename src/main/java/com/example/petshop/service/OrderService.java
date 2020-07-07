package com.example.petshop.service;

import com.example.petshop.dto.OrderResponseDto;
import com.example.petshop.dto.OrdersDetailsListResponseDto;


public interface OrderService {

	public OrderResponseDto orderPetsByPetId(int userId, int petId) ;

	public OrdersDetailsListResponseDto getOrdersListByUserId(int userId);

	
		

}
