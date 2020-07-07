package com.example.petshop.controllertest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.petshop.controller.UserController;
import com.example.petshop.dto.LoginRequestDto;
import com.example.petshop.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	ObjectMapper objectMapper;

	@Mock
	UserService userService;

	@InjectMocks
	UserController userController;

	MockMvc mockMvc;

	LoginRequestDto loginRequestDto;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

		loginRequestDto = new LoginRequestDto();
		loginRequestDto.setPassword("moni");
		loginRequestDto.setUserName("monisha");;

	}

	@Test
	public void loginTest() throws Exception {
		// given
		when(userService.authenticateUser("monisha", "moni")).thenReturn(true);

		// when and then
		mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(loginRequestDto))).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.is("logged in successfully")));

		verify(userService).authenticateUser("monisha", "moni");
	}

	@Test
	public void loginTest1() throws Exception {
		// given
		when(userService.authenticateUser("monisha", "moni")).thenReturn(false);

		// when and then
		mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(loginRequestDto))).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.is("Credentials are incorrect")));

		verify(userService).authenticateUser("monisha","moni");
	}

}
