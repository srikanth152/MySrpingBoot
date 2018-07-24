package course.config.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.config.model.Address;
import course.config.model.Customer;
import course.config.model.Student;
import course.config.model.Teacher;
import course.config.model.User;
import course.config.model.Vehicle;
import course.config.repository.UserDetailsDAO;
import course.config.resource.UserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDetailsDAO userDetailsDao;

	@Override
	public void addUser(UserDetails userDetails) {
		
		User user = convert(userDetails);
		userDetailsDao.addUser(user);
	}

	private User convert(UserDetails userDetails) {
		User user = new User(userDetails.getFirstName(),userDetails.getLastName(),userDetails.getEmail()
				,userDetails.getPassword());
		
		Address address = new Address(userDetails.getAddressDetails().getCountry(), userDetails.getAddressDetails().getState(), 
				userDetails.getAddressDetails().getCity(), userDetails.getAddressDetails().getStreet());
		
		Address address2 = new Address(userDetails.getAddressDetails().getCountry(), userDetails.getAddressDetails().getState(), 
				userDetails.getAddressDetails().getCity(), userDetails.getAddressDetails().getStreet());
		
		List<Address> li = new ArrayList<>();
		li.add(address);
		li.add(address2);
		
		user.setAddress(li);
		return user;
	}

	@Override
	public void oneToOne() {
		Customer c = new Customer("Srikanth", 31);
		Vehicle v = new Vehicle("Apache");
		c.setVehicle(v);
		userDetailsDao.oneToOne(c);
	}

	@Override
	public void oneToMany() {
		Teacher t = new Teacher("Joseph", "English");
		
		Student s1 = new Student("harish", 31);
		Student s2 = new Student("Rajesh", 31);
		
		t.getStudent().add(s1);
		t.getStudent().add(s2);
		
		userDetailsDao.oneToMany(t);
	}

	@Override
	public void manyToOne() {
		
	}

	@Override
	public void singleTable() {
		userDetailsDao.singleTableStrategy();
	}
	
}
