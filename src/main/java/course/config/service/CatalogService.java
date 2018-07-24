package course.config.service;

import course.config.model.Topic;

public interface CatalogService {

	public void createCourse(String courseName, String description, String courseContent);

	public Topic getCourseDetails(long courseId);
}
