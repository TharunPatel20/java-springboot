package jwt.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String greet() {
		
		return "welcome to spring-security-demo-project homepage [No-Auth]";
	}

}
