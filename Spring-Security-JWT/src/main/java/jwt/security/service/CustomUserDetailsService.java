package jwt.security.service;

import java.util.Objects;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jwt.security.mongoModel.CustomUserDetails;
import jwt.security.mongoModel.User;
import jwt.security.mongoRepository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepo = userRepository;
    }

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user  = userRepo.findByUsername(username);
		
		if(Objects.isNull(user)) {
			throw new UsernameNotFoundException("user not found");
		}
		
		return new CustomUserDetails(user);
	}

}
