package com.fms.service;

import com.fms.dto.SignupDTO;
import com.fms.dto.UserDTO;

public interface UserService {
	UserDTO createUser(SignupDTO signupDTO);

}
