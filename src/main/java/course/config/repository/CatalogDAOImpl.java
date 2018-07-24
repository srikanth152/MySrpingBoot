package course.config.repository;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import course.config.model.Topic;

@Repository
public class CatalogDAOImpl implements CatalogDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void createCourse(String courseName, String description, String courseContent) {
		String sql = "insert into catalog_details(course_name,description,course_content) "
				+ "values("+":course_name,"+":description,"+":courseContent)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("course_name", courseName);
		params.addValue("description", description);
		params.addValue("courseContent", courseContent);
		
		jdbcTemplate.update(sql, params, keyHolder, new String[]{"course_id"});
		long id = keyHolder.getKey().longValue();
		System.out.println(" @@@@@@@@@@ "+id);
		
	}

	@Override
	public Topic getCourseDetails(long courseId) {
		String sql = "select course_id,course_name,description from catalog_details where course_id = :courseId";
		SqlParameterSource params = new MapSqlParameterSource("courseId", courseId);
		return jdbcTemplate.query(sql, params, (ResultSet rs,int row) -> {
			Topic e=new Topic();  
	        e.setId(rs.getString(1));  
	        e.setName(rs.getString(2));  
	        e.setDescription(rs.getString(3));  
	        return e;  	
		}).get(0);
	}

}
