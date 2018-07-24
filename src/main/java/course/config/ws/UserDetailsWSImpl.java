package course.config.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import course.config.resource.UserDetails;
import course.config.service.UserDetailsService;

@RestController
public class UserDetailsWSImpl implements UserDetailsWS{
	
	@Autowired
	private UserDetailsService userService;

	@Override
	public void addUser(@RequestBody UserDetails user) {
		userService.addUser(user);
	}

	@Override
	public void oneToOne() {
		userService.oneToOne();
	}

	@Override
	public void oneToMany() {
		userService.oneToMany();
	}

	@Override
	public void manyToOne() {
		
	}

	@Override
	public void singleTable() {
		
	}
	
}
