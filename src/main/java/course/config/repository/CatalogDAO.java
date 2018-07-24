package course.config.repository;

import course.config.model.Topic;

public interface CatalogDAO {

	public void createCourse(String courseName, String description, String courseContent);

	public Topic getCourseDetails(long courseId);
	
}
