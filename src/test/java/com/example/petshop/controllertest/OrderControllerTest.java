package com.example.petshop.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.petshop.controller.OrderController;
import com.example.petshop.dto.OrderRequestDto;
import com.example.petshop.dto.OrderResponseDto;
import com.example.petshop.dto.OrdersDetailsListResponseDto;
import com.example.petshop.service.OrderService;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
	@InjectMocks
	OrderController orderController;

	@Mock
	OrderService orderService;

	@Test
	public void orderDetails() {

		OrderRequestDto booking = new OrderRequestDto();
		booking.setPetId(1);

		OrderResponseDto book = new OrderResponseDto();
		book.setMessage("Please find the list of available books");
		book.setStatusCode(200);

		Mockito.when(orderService.orderPetsByPetId(1, 1)).thenReturn(book);

		ResponseEntity<OrderResponseDto> responsebusdetailsdto = orderController.orderPets(1, booking);
		assertEquals(HttpStatus.OK, responsebusdetailsdto.getStatusCode());

	}

	@Test
	public void orderListDetails() {

		OrdersDetailsListResponseDto petsList = new OrdersDetailsListResponseDto();
		petsList.setMessage("Please find the list of available books");
		petsList.setStatusCode(200);

		Mockito.when(orderService.getOrdersListByUserId(1)).thenReturn(petsList);

		ResponseEntity<OrdersDetailsListResponseDto> responsebusdetailsdto = orderController.getOrdersList(1);
		assertEquals(HttpStatus.OK, responsebusdetailsdto.getStatusCode());

	}
}
