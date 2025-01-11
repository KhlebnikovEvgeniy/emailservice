package com.khlebnikovevgeniy.emailservice.resource;

import static java.time.LocalDateTime.now;

import java.net.URI;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khlebnikovevgeniy.emailservice.domain.HttpResponse;
import com.khlebnikovevgeniy.emailservice.domain.User;
import com.khlebnikovevgeniy.emailservice.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserResource {
	private final UserService userService;
	
																//TODO UserDto
	@PostMapping
	public ResponseEntity<HttpResponse> createUser(@RequestBody User user) {
		User newUser = userService.saveUser(user);
		return ResponseEntity.created(URI.create("")).body(
							HttpResponse.builder()
										.timeStamp(now().toString())
										.data(Map.of("user", newUser))
										.message("User created")
										.status(HttpStatus.CREATED)
										.statusCode(HttpStatus.CREATED.value())
										.build()
		);	
	}
	
	@GetMapping
	public ResponseEntity<HttpResponse> confirmUserAccount (@RequestParam("token") String token) {
		Boolean isSuccess = userService.verifyToken(token);
		return ResponseEntity.ok().body(
							HttpResponse.builder()
										.timeStamp(now().toString())
										.data(Map.of("Success", isSuccess))
										.message("Account verified")
										.status(HttpStatus.OK)
										.statusCode(HttpStatus.OK.value())
										.build()
		);	
	}
}
