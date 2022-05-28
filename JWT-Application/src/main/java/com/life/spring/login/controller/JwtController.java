package com.life.spring.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.life.spring.login.entity.JwtRequestEntity;
import com.life.spring.login.entity.JwtResponse;
import com.life.spring.login.jwt.helper.JwtTokenUtil;
import com.life.spring.login.jwt.services.CustomAdminDetailService;

@RestController
@CrossOrigin
@RequestMapping("/jwtapi")
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomAdminDetailService adminDetailService;

	@Autowired
	private JwtTokenUtil jwtUtil;

	@PostMapping("/admin/login")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequestEntity jwtEntity) throws Exception {
		System.out.println("jwtEntity : " + jwtEntity);
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtEntity.getUserName(), jwtEntity.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		System.out.println("authenticationManager: "+authenticationManager);
		UserDetails details = this.adminDetailService.loadUserByUsername(jwtEntity.getUserName());
		String token = this.jwtUtil.generateToken(details);
		System.out.println("Token : " + token);
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
