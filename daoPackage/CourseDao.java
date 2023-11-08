package daoPackage;

import java.util.List;

import javaBeans.Course;

public interface CourseDao {

	public Course getCourse(Long course_id);

	public Course deleteCourse(Long course_id);

	public List<Course> getCourse();

	public Boolean addCourse(Course course);

}
