package course.config.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import course.config.model.Topic;
import course.config.resource.CourseCatalog;
import course.config.service.CatalogService;

@RestController
public class CatalogwsImpl implements Catalogws{
	
	@Autowired
	private CatalogService catalogService;
	
	@Override
	public void createCourse(@RequestBody CourseCatalog courseCatalog) {
		 catalogService.createCourse(courseCatalog.getCourseName(), 
				 courseCatalog.getDescription(), courseCatalog.getContent());
	}

	@Override
	public List<String> getAllCourses() {
		return null;
	}

	@Override
	public Topic getCourseDetails(@PathVariable("id") String id) {
		System.out.println(id);
		return catalogService.getCourseDetails(Long.valueOf(id));
	}


}
