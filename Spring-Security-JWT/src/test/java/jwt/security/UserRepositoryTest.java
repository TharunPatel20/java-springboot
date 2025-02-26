package jwt.security;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import jwt.security.mongoModel.User;
import jwt.security.mongoRepository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepo;
	
//	@Test
//	public void addUsers() {
//		
//		List<User> users = new ArrayList<User>();
//		users.add(new User("user3", "password"));
//		users.add(new User("user2", "password"));
//		users.add(new User("user1", "password"));
//		
//		userRepo.saveAll(users);
//	}
	
	@Test
	public void getUsers() {	
		System.out.println(userRepo.findAll());
	}
}
