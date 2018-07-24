package course.config.messaging;

import org.springframework.stereotype.Component;

@Component
public class Person {
	
	private String name;

	public String getName() {
		return "hello srikanth";
	}

	public void setName(String name) {
		this.name = name;
	}

}
