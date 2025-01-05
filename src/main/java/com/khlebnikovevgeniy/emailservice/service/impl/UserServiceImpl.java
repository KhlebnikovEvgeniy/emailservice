package com.khlebnikovevgeniy.emailservice.service.impl;

import org.springframework.stereotype.Service;

import com.khlebnikovevgeniy.emailservice.domain.Confirmation;
import com.khlebnikovevgeniy.emailservice.domain.User;
import com.khlebnikovevgeniy.emailservice.repository.ConfirmationRepository;
import com.khlebnikovevgeniy.emailservice.repository.UserRepository;
import com.khlebnikovevgeniy.emailservice.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ConfirmationRepository confirmationRepository;
	
	@Override
	public User saveUser(User user) {
		if (userRepository.existsByEmail(user.getEmail())) { throw new RuntimeException("Email aready exists");	}
		user.setEnabled(false);
		userRepository.save(user);
		
		Confirmation confirmation = new Confirmation(user);
		confirmationRepository.save(confirmation);
		
		/* TODO Send Email to the user with the token*/
		
		return user;
	}

	@Override
	public Boolean verifyToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
