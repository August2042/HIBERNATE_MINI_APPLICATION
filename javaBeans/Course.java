package javaBeans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long course_id;
	private String course_name;
	private Integer course_duration;
	private String course_faculty;
	private Double course_fees;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String course_name, Integer course_duration, String course_faculty, Double course_fees) {
		super();
		this.course_name = course_name;
		this.course_duration = course_duration;
		this.course_faculty = course_faculty;
		this.course_fees = course_fees;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public Integer getCourse_duration() {
		return course_duration;
	}

	public void setCourse_duration(Integer course_duration) {
		this.course_duration = course_duration;
	}

	public String getCourse_faculty() {
		return course_faculty;
	}

	public void setCourse_faculty(String course_faculty) {
		this.course_faculty = course_faculty;
	}

	public Double getCourse_fees() {
		return course_fees;
	}

	public void setCourse_fees(Double course_fees) {
		this.course_fees = course_fees;
	}

	public Long getCourse_id() {
		return course_id;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_duration="
				+ course_duration + ", course_faculty=" + course_faculty + ", course_fees=" + course_fees + "]";
	}

}
