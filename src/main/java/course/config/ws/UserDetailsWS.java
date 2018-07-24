package course.config.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import course.config.resource.UserDetails;

@RequestMapping("/user")
public interface UserDetailsWS {
	
	@RequestMapping(value="/add", method=RequestMethod.POST
			,consumes="application/json")
	public void addUser(UserDetails user);
	
	@RequestMapping(value="/one-to-one", method=RequestMethod.GET)
	public void oneToOne();
	
	@RequestMapping(value="/one-to-many", method=RequestMethod.GET)
	public void oneToMany();
	
	@RequestMapping(value="/many-to-one", method=RequestMethod.GET)
	public void manyToOne();
	
	@RequestMapping(value="/singleTable", method=RequestMethod.GET)
	public void singleTable();
	
}
