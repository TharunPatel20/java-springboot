package jwt.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jwt.security.mongoModel.User;
import jwt.security.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

   
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
    	return userService.register(user);
        
    }

    @PostMapping("/login")
    public String verifyUser(@RequestBody User user) {
    	return userService.verify(user);
    }
}
