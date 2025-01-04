package com.khlebnikovevgeniy.emailservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khlebnikovevgeniy.emailservice.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmailIgnoreCase(String email);
	Boolean existsByEmail(String email);
}
