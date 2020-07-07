package com.example.petshop.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.petshop.dao.OrderDao;
import com.example.petshop.dao.PetDao;
import com.example.petshop.dao.UserDao;
import com.example.petshop.dto.OrderResponseDto;
import com.example.petshop.dto.OrdersDetailsListResponseDto;
import com.example.petshop.dto.OrdersListResponseDto;

import com.example.petshop.exception.InvalidCredentialsException;
import com.example.petshop.model.OrderPets;
import com.example.petshop.model.Pet;
import com.example.petshop.model.User;
import com.example.petshop.service.OrderService;

@Service
public class OrderServiceImpl  implements OrderService{
	@Autowired
	UserDao userDao;
	@Autowired
	OrderDao orderDao;
	@Autowired
	PetServiceImpl petServiceImpl;
	@Autowired
	PetDao petDao;
	

	
	
	@Override
	public OrderResponseDto orderPetsByPetId(int userId, int petId) {
		
		OrderPets orderPets = new OrderPets();
		OrderResponseDto orderResponseDto = new OrderResponseDto();
		Optional<User> user = userDao.findAllByUserId(userId);
		 if (!user.isPresent()) {
			 throw new InvalidCredentialsException("UserId is not valid,Enter correct one");
			
		 }
		 orderPets.setUserId(userId);
		 orderPets.setPetId(petId);
		 orderPets.setOrderDateTime(LocalDateTime.now());
		 orderDao.save(orderPets);
		 petServiceImpl.updatePetStatus(petId);
		 orderResponseDto.setMessage("PetOrderSuccessfully");
		 orderResponseDto.setStatusCode(HttpStatus.OK.value());
		 return  orderResponseDto;
		 
	}


	@Override
	public OrdersDetailsListResponseDto getOrdersListByUserId(int userId) {
		
		OrdersDetailsListResponseDto ordersDetailsListResponseDto = new OrdersDetailsListResponseDto();
	        Optional<List<OrderPets>> petDetails=orderDao.findAllByUserId(userId);
	        if (!petDetails.isPresent()) {
				
	        	throw new InvalidCredentialsException("NoT a valid user.check userId");
			}
	      
	         List<OrdersListResponseDto> orderPetList= petDetails.get().stream().map(orderPets -> getPetDetailsResponseDto(orderPets)).collect(Collectors.toList());
	         ordersDetailsListResponseDto.setMessage("order history of pets");
	         ordersDetailsListResponseDto.setStatusCode(HttpStatus.OK.value());
	         ordersDetailsListResponseDto.setOrdersListResponseDto(orderPetList);
				return ordersDetailsListResponseDto;
	            
	       
	         
	    }
	    private OrdersListResponseDto getPetDetailsResponseDto(OrderPets orderPets) {
	        
	    	OrdersListResponseDto ordersListResponseDto=new OrdersListResponseDto();
	    	Pet petDetail=petDao.findAllByPetId(orderPets.getPetId());
	    	ordersListResponseDto.setPetName(petDetail.getPetName());
	    	ordersListResponseDto.setPrice(petDetail.getPrice());
	    	ordersListResponseDto.setDescription(petDetail.getDescription());
	    	
	        BeanUtils.copyProperties(orderPets, ordersListResponseDto);
	        return ordersListResponseDto;
	    }
	}


