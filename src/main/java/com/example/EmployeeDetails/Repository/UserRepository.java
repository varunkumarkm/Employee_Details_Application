package com.example.EmployeeDetails.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeDetails.Entitiy.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	Optional<User> findByEmail(String email);
//	
	Optional<User> findByUsernameOrEmail(String username, String email);
//	
//	Optional<User> findByUserName(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String emial);
}
