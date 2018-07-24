package course.config.repository;

import course.config.model.Customer;
import course.config.model.Teacher;
import course.config.model.User;

public interface UserDetailsDAO {

	public void addUser(User user);
	
	public void oneToOne(Customer c);
	
	public void oneToMany(Teacher t);
	
	public void oneToOne();
	
	public void singleTableStrategy();

}
