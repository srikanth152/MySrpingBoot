package course;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service("StartupService")
@Scope("prototype")
public class Demo  implements ApplicationListener<ContextRefreshedEvent>{
	
	public Demo(){
		System.out.println("Constructor");
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		System.out.println("Hello @@@@@@@@@@@@@");
	}
	
	@PostConstruct
	private void startupApplication() {
		System.out.println("Cache is created");
	}
	
	public void m(){
		System.out.println("helllllllooooooooooo");
	}
	
	@PreDestroy
	private void destroyApplication() {
		System.out.println("Destroy is called ");
	}
}
