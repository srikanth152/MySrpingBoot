package course.config.ws;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import course.config.model.Topic;
import course.config.resource.CourseCatalog;

@RequestMapping("/catalog")
public interface Catalogws {
		
	@RequestMapping(value="/create", method=RequestMethod.POST
			,consumes="application/json", produces="application/json")
	public void createCourse(CourseCatalog courseCatalog);
	
	default public boolean updateCourse(){
		return false;
	}
	
	default public boolean deleteCourse(){
		return false;
	}
	
	public List<String> getAllCourses();
	
	@GetMapping(value="/coursedetails/{id}", consumes="application/json", produces="application/json")
	 public Topic getCourseDetails(@PathVariable("id") String id);
}
