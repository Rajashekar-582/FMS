package com.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.fms.dto.SignupDTO;
import com.fms.dto.UserDTO;
import com.fms.service.UserService;




@RestController
public class SignUpUserController
{
	@Autowired
	private UserService userService;
	 
	@PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signUpDTO) {
       UserDTO createdUser = userService.createUser(signUpDTO);
       if (createdUser == null){
           return new ResponseEntity<>("UserService not created, come again later!", HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
	
	
	
}

