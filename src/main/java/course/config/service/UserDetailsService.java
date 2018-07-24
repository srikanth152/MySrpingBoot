package course.config.service;

import course.config.resource.UserDetails;

public interface UserDetailsService {

	public void addUser(UserDetails userDetails);
	
	public void oneToOne();
	
	public void oneToMany();
	
	public void manyToOne();

	public void singleTable();
}
