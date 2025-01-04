package com.khlebnikovevgeniy.emailservice.service;

import com.khlebnikovevgeniy.emailservice.domain.User;

public interface UserService {
	User saveUser(User user);
	Boolean verifyToken(String token);
}
