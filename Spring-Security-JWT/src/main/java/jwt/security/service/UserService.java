package jwt.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jwt.security.mongoModel.User;
import jwt.security.mongoRepository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

	public String register(User user) {
		User foundUser = userRepository.findByUsername(user.getUsername());
		
		if (foundUser != null && foundUser.getUsername().equals(user.getUsername())) return "user exixts";
		else {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); // Hash password
			userRepository.save(user);
			return user.toString();
		}
	}

	public String verify(User user) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authenticate.isAuthenticated())
            return jwtService.generateToken(user);
        return "failure";	
		
		// for user name and  password authentication
		
/*		User foundUser = userRepository.findByUsername(user.getUsername());
		if(foundUser == null) return "user not found";
		boolean found = bCryptPasswordEncoder.matches(user.getPassword(), foundUser.getPassword());
		return (foundUser != null) ? (found ? "login success!" : "wrong password!") : "user not found!";
 */
	}
}