package course.config.repository;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import course.config.model.Customer;
import course.config.model.Stock;
import course.config.model.StockDetail;
import course.config.model.Student;
import course.config.model.Teacher;
import course.config.model.User;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public void addUser(User user) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void oneToOne(Customer customer) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void oneToMany(Teacher t) {
		Teacher teacher = new Teacher("Joseph", "English");
		
		Student s1 = new Student("harish", 31);
		s1.setTeacher(t);
		
		Student s2 = new Student("Rajesh", 31);
		s2.setTeacher(t);
		
		t.getStudent().add(s1);
		t.getStudent().add(s2);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(teacher);
		session.save(s1);
		session.save(s2);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void oneToOne() {
		
		Stock stock = new Stock();

		stock.setStockCode("7052");
		stock.setStockName("PADINI");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(stock);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void singleTableStrategy() {
		
	}
	
	
}
