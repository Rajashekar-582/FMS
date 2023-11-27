package com.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fms.dto.SignupDTO;
import com.fms.dto.UserDTO;
import com.fms.entities.User;
import com.fms.enums.UserRole;
import com.fms.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService
{
   @Autowired
   private UserRepository userRepository;
   
   @PostConstruct
   public void createAdminAccount()
   {
	   User adminAccount =userRepository.findByUserRole(UserRole.ADMIN);
	   if(adminAccount== null)
	   {
		   User user=new User();
		   user.setUserRole(UserRole.ADMIN);
		   user.setEmail("admin@test.com");
		   user.setName("admin");
		   user.setPassword(new BCryptPasswordEncoder().encode("admin"));
		   userRepository.save(user);
		   
	   }
   }
  

@Override
public UserDTO createUser(SignupDTO signupDTO) {
	 User user = new User();
     user.setName(signupDTO.getName());
     user.setEmail(signupDTO.getEmail());
     user.setUserRole(UserRole.USER);
     user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
     User createdUser = userRepository.save(user);
     UserDTO userDTO = new UserDTO();
     userDTO.setId(createdUser.getId());
     userDTO.setEmail(createdUser.getEmail());
     userDTO.setName(createdUser.getName());
     userDTO.setUserRole(createdUser.getUserRole());
     return userDTO;
}
}
