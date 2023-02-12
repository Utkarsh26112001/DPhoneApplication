package com.dphone.user.controller;

import com.dphone.user.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequiredArgsConstructor

@RequestMapping("/api/v1/auth/user")
public class UserController {
	


	private final AuthenticationService service;

	@GetMapping("/home")
	
	public String test() {
		
		return "hello";
	}

	@PostMapping("/register")


	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){

      return ResponseEntity.ok(service.register(request));
	}

	@PostMapping("/authenticate")

	public ResponseEntity<AuthenticationResponse> authenticateRequest(@RequestBody AuthenticationRequest request){

		return ResponseEntity.ok(service.authenticate(request));

	}
}
