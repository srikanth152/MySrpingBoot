package course.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.config.model.Topic;
import course.config.repository.CatalogDAO;

@Service
public class CatalogServiceImpl implements CatalogService {
	
	@Autowired
	private CatalogDAO catalogDAO;
	
	@Override
	public void createCourse(String courseName, String description, String courseContent) {
		 catalogDAO.createCourse(courseName, description, courseContent);
	}

	@Override
	public Topic getCourseDetails(long courseId) {
		return catalogDAO.getCourseDetails(courseId);
	}


}
