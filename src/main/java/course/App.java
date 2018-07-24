package course;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/app.properties")
public class App extends SpringBootServletInitializer implements CommandLineRunner {
	
	@Autowired
    private ApplicationContext appContext;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
        String[] beans = appContext.getBeanDefinitionNames();
        System.out.println(" ************** "+appContext.getBeanDefinitionCount());
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
            /*String scope = ((AnnotationConfigApplicationContext)appContext).getBeanFactory().getBeanDefinition(bean).getScope();
            System.out.println(scope);*/
        }
    }

}
