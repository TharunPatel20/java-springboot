package jwt.security.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jwt.security.mongoModel.User;
import jwt.security.mongoRepository.UserRepository;
import jwt.security.service.JwtService;



@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	JwtService jwtService;
	
	@GetMapping
	public String authGreet() {
		return "yau are here after successful Authentication🥳 [Basic-Auth]";
	}
	
	@GetMapping("/userinfo")
	public String getUserDetails(@RequestHeader Map<String, String> headers) {
//		 headers.forEach((key, value) -> {
//		        System.out.println("Header Name: " + key + " Header Value: " + value);
//		    });
//		 
//		 return headers;
		String token = headers.get("authorization").substring(7);
		
		return userRepo.findByUsername(jwtService.extractUserName(token)).toString() + token;
		
	}
}
