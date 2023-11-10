package daoPackage;

import java.util.List;

import javaBeans.Student;

public interface StudentDao {

	public Student getStudent(Long student_id);

	public Student deleteStudent(Long student_id);

	public List<Student> getStudent();

	public Boolean addStudent(Student student);

	public Boolean updateStudent(Student student);

}
