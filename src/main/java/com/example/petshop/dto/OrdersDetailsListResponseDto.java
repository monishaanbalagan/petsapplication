package com.example.petshop.dto;

import java.util.List;

public class OrdersDetailsListResponseDto {
	private String message;
	private int statusCode;
	List<OrdersListResponseDto> ordersListResponseDto;
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
	public List<OrdersListResponseDto> getOrdersListResponseDto() {
		return ordersListResponseDto;
	}
	public void setOrdersListResponseDto(List<OrdersListResponseDto> ordersListResponseDto) {
		this.ordersListResponseDto = ordersListResponseDto;
	}

}
