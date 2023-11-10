package rootPackage;

import java.util.Scanner;

import javax.validation.groups.Default;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

import daoImpPackage.CourseDaoImpl;
import daoImpPackage.StudentDaoImpl;
import daoPackage.CourseDao;
import daoPackage.StudentDao;
import hibernateConfigurationPackage.HibernateConfiguration;
import javaBeans.Course;
import javaBeans.Student;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cont;
		char perform;
		do {
			System.out.println("Welcome to Hibernate Program");
			System.out.println("-----------------------------");

			System.out.println("Select the option :");
			System.out.println("1>. STUDENT ");
			System.out.println("2>. COURSE");
			int option = sc.nextInt();

			switch (option) {

			case 1: {

				/* This is for STUDENT */
				System.out.println("WELCOME TO STUDENT MANAGEMENT SYSTEM USING HIBERNATE ");
				System.out.println("-----------------------------------------------------");
				System.out.println("1>. Add Student");
				System.out.println("2>. Delete Student");
				System.out.println("3>. Get Student by ID");
				System.out.println("4>. Update Student");
				System.out.println("5>. Get Student List");

				System.out.println("Enter the above choice :");
				int option1 = sc.nextInt();
				sc.nextLine();

				switch (option1) {
				case 1: {

					/* Add Student */
//					Scanner sc = new Scanner(System.in);
					System.out.print("Enter the student name : ");
					String s_name = sc.nextLine();
					System.out.print("Enter the gender : ");
					String s_gender = sc.nextLine();
					System.out.print("Enter the student email : ");
					String s_email = sc.nextLine();
					System.out.print("Enter the student mobile no. : ");
					String s_mobNo = sc.nextLine();
					System.out.print("Enter the student address : ");
					String s_address = sc.nextLine();
					System.out.print("Enter the student age : ");
					String s_Age = sc.nextLine();

					StudentDao studentDao = new StudentDaoImpl();
					Student student = new Student(s_name, s_gender, s_email, s_mobNo, s_address, s_Age);
					studentDao.addStudent(student);

					break;
				}
				case 2: {
					/* Delete Student */
					System.out.print("Enter the student id for deleting student details : ");
					Long s_id = sc.nextLong();
					sc.nextLine();

					StudentDao obj = new StudentDaoImpl();
					Student obj1 = obj.deleteStudent(s_id);

					if (obj1 != null) {
						System.out.println("Deleted Student Details:");
						System.out.println("ID: " + obj1.getStudent_id());
						System.out.println("Name: " + obj1.getStudent_name());
						System.out.println("Gender: " + obj1.getStudent_gender());
						System.out.println("Email: " + obj1.getStudent_email());
						System.out.println("Mobile No.: " + obj1.getStudent_mobileNo());
						System.out.println("Age.: " + obj1.getStudent_age());
					} else {
						System.out.println("Student not found with the provided ID.");
					}

					break;
				}
				case 3: {
					/* Get Student */

					System.out.print("Enter the student id: ");
					Long s_id = sc.nextLong();
					sc.nextLine(); // Consume the newline character left in the buffer

					StudentDao obj = new StudentDaoImpl();
//					Course course = obj.getCourse(s_id);
					Student std = obj.getStudent(s_id);

					if (std != null) {
						System.out.println("Course Details:");
						System.out.println("ID: " + std.getStudent_id());
						System.out.println("Name: " + std.getStudent_name());
						System.out.println("Gender: " + std.getStudent_gender());
						System.out.println("Email: " + std.getStudent_email());
						System.out.println("Mobile No.: " + std.getStudent_mobileNo());
						System.out.println("Age.: " + std.getStudent_age());

					} else {
						System.out.println("Student not found with the provided ID.");
					}

					break;
				}
				case 4: {
					System.out.print("Enter the student id for updating student details : ");
					Long s_id = sc.nextLong();
					sc.nextLine();

					StudentDao studentDao = new StudentDaoImpl();
					Student existingStudent = studentDao.getStudent(s_id);

					if (existingStudent != null) {
						System.out.println("Enter updated information for student with ID " + s_id + ":");

						System.out.print("Enter the updated student name : ");
						String updatedName = sc.nextLine();
						existingStudent.setStudent_name(updatedName);

						System.out.print("Enter the updated gender : ");
						String updatedGender = sc.nextLine();
						existingStudent.setStudent_gender(updatedGender);

						System.out.print("Enter the updated student email : ");
						String updatedEmail = sc.nextLine();
						existingStudent.setStudent_email(updatedEmail);

						System.out.print("Enter the updated student mobile no. : ");
						String updatedMobNo = sc.nextLine();
						existingStudent.setStudent_mobileNo(updatedMobNo);

						System.out.print("Enter the updated student address : ");
						String updatedAddress = sc.nextLine();
						existingStudent.setStudent_address(updatedAddress);

						System.out.print("Enter the updated student age : ");
						String updatedAge = sc.nextLine();
						existingStudent.setStudent_age(updatedAge);

						// Call the update method
						if (studentDao.updateStudent(existingStudent)) {
							System.out.println("Student details updated successfully.");
						} else {
							System.out.println("Failed to update student details.");
						}
					} else {
						System.out.println("Student not found with the provided ID.");
					}

					break;
				}
				case 5: {
					/* Get Students */
					StudentDao studentDao = new StudentDaoImpl();
					List<Student> students = studentDao.getStudent();

					if (!students.isEmpty()) {
						System.out.println("List of Students:");
						for (Student std : students) {
							System.out.println("ID: " + std.getStudent_id());
							System.out.println("Name: " + std.getStudent_name());
							System.out.println("Gender: " + std.getStudent_gender());
							System.out.println("Email: " + std.getStudent_email());
							System.out.println("Mobile No.: " + std.getStudent_mobileNo());
							System.out.println("Age.: " + std.getStudent_age());
							System.out.println("----------------------");
						}
					} else {
						System.out.println("No students found.");
					}

					break;
				}

				default:
					throw new IllegalArgumentException("Unexpected value: " + option1);
				}

				break;
			}

			case 2: {
				/* This is for Course */
				System.out.println("WELCOME TO COURSE MANAGEMENT SYSTEM USING HIBERNATE");
				System.out.println("---------------------------------------------------");
				System.out.println("1>. Add Course");
				System.out.println("2>. Delete Course");
				System.out.println("3>. Get Course");
				System.out.println("4>. Update Course");
				System.out.println("5>. Get Course List");
				System.out.println("Enter the above choice :");
				int option2 = sc.nextInt();
				sc.nextLine();

				switch (option2) {
				case 1: {
					/* Add Course */
					System.out.print("Enter the course name : ");
					String cName = sc.nextLine();

					System.out.print("Enter the course duration : ");
					Integer cDuration = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter the trainer name : ");
					String cTrainer = sc.nextLine();

					System.out.print("Enter the trainer Fess : ");
					Double cFees = sc.nextDouble();

					CourseDao obj = new CourseDaoImpl();
					Course obj1 = new Course(cName, cDuration, cTrainer, cFees);
					obj.addCourse(obj1);

					break;
				}
				case 2: {

					/* Delete Course */
					System.out.print("Enter the course id for deleting course details : ");
					Long c_id = sc.nextLong();
					sc.nextLine();

					CourseDao obj = new CourseDaoImpl();
					Course obj1 = obj.deleteCourse(c_id);

					if (obj1 != null) {
						System.out.println("Course Deleted:");
						System.out.println("ID: " + obj1.getCourse_id());
						System.out.println("Name: " + obj1.getCourse_name());
						System.out.println("Duration: " + obj1.getCourse_duration());
						System.out.println("Trainer: " + obj1.getCourse_faculty());
						System.out.println("Fees: " + obj1.getCourse_fees());
					} else {
						System.out.println("Course not found with the provided ID.");
					}

					break;
				}
				case 3: {
					/* Get Course */
					System.out.print("Enter the course id: ");
					Long c_id = sc.nextLong();
					sc.nextLine(); // Consume the newline character left in the buffer

					CourseDao obj = new CourseDaoImpl();
					Course course = obj.getCourse(c_id);

					if (course != null) {
						System.out.println("Course Details:");
						System.out.println("ID: " + course.getCourse_id());
						System.out.println("Name: " + course.getCourse_name());
						System.out.println("Duration: " + course.getCourse_duration());
						System.out.println("Trainer: " + course.getCourse_faculty());
						System.out.println("Fees: " + course.getCourse_fees());
					} else {
						System.out.println("Course not found with the provided ID.");
					}

					break;
				}
				case 4: {
					/* Update Course */
					System.out.print("Enter the course id for updating course details : ");
					Long c_id = sc.nextLong();
					sc.nextLine();

					CourseDao obj = new CourseDaoImpl();
					Course existingCourse = obj.getCourse(c_id);

					if (existingCourse != null) {
						// Display existing course details
						System.out.println("Existing Course Details:");
						System.out.println("ID: " + existingCourse.getCourse_id());
						System.out.println("Name: " + existingCourse.getCourse_name());
						System.out.println("Duration: " + existingCourse.getCourse_duration());
						System.out.println("Trainer: " + existingCourse.getCourse_faculty());
						System.out.println("Fees: " + existingCourse.getCourse_fees());

						// Take input for updated course details
						System.out.print("Enter the new course name : ");
						String newCName = sc.nextLine();

						System.out.print("Enter the new course duration : ");
						Integer newCDuration = sc.nextInt();
						sc.nextLine();

						System.out.print("Enter the new trainer name : ");
						String newCTrainer = sc.nextLine();

						System.out.print("Enter the new trainer fees : ");
						Double newCFees = sc.nextDouble();
						sc.nextLine();

						// Update the course details
						existingCourse.setCourse_name(newCName);
						existingCourse.setCourse_duration(newCDuration);
						existingCourse.setCourse_faculty(newCTrainer);
						existingCourse.setCourse_fees(newCFees);

						// Call the updateCourse method
						if (obj.updateCourse(existingCourse)) {
							System.out.println("Course Updated Successfully.");
						} else {
							System.out.println("Failed to update the course.");
						}
					} else {
						System.out.println("Course not found with the provided ID.");
					}

					break;
				}
				case 5: {
					/* Get Courses */
					CourseDao courseDao = new CourseDaoImpl();
					List<Course> courses = courseDao.getCourse();

					if (!courses.isEmpty()) {
						System.out.println("List of Courses:");
						for (Course course : courses) {
							System.out.println("ID: " + course.getCourse_id());
							System.out.println("Name: " + course.getCourse_name());
							System.out.println("Duration: " + course.getCourse_duration());
							System.out.println("Trainer: " + course.getCourse_faculty());
							System.out.println("Fees: " + course.getCourse_fees());
							System.out.println("----------------------");
						}
					} else {
						System.out.println("No courses found.");
					}

					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + option2);
				}

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
			}

//			SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
			//
//			Student s1 = new Student("August kumar","Male","augustkumar2014@gmail.com","9953182042","Delhi","22");
			//
//			Course c1 = new Course("APJF",3,"Mukesh Kumar Jangid",50000.0);
			//
//			Session session = sessionFactory.openSession();
//			Transaction transaction = null;
			//
//			try {
//				transaction = session.beginTransaction();
//				session.persist(s1);
//				session.persist(c1);
//				transaction.commit();
//			} catch (Exception e) {
//				if (transaction != null) {
//					transaction.rollback(); // Rollback the transaction in case of an exception
//				}
//				e.printStackTrace();
//			} finally {
//				session.close();
//				sessionFactory.close();
//			}

			System.out.println("If you want to continue this program then press 1 or else any number...");
			cont = sc.nextInt();

		} while (cont == 1);
		System.out.print("********** Thankyou for using this application **********");

	}
}
