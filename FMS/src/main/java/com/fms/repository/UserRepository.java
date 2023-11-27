package com.fms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.entities.User;
import com.fms.enums.UserRole;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	User findFirstByEmail(String email);

	User findByUserRole(UserRole admin);

}
