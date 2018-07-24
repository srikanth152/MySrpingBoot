package course.config.messaging;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringDependencyTest {
	
	@Autowired
	private Person p;
	private String name;

	public SpringDependencyTest(){
		System.out.println(" &&&&&&&&&&&&&&& "+this.name);
	}
	
	@PostConstruct
	public void init(){
		System.out.println(" &&&&&&&&&&&&&&&&77777777 "+p.getName());
	}
	
}
