package daoImpPackage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory; // Import the correct SessionFactory

import daoPackage.CourseDao;
import hibernateConfigurationPackage.HibernateConfiguration;
import org.hibernate.Transaction;
import javaBeans.Course;

public class CourseDaoImpl implements CourseDao {

	@Override
	public Boolean addCourse(Course course) {

		SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(course);
			transaction.commit();
			return true;

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}

	}

	@Override
	public Course getCourse(Long course_id) {
		SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Course course = session.get(Course.class, course_id);
		session.close(); // Don't forget to close the session.
		return course; // Return the retrieved course object, or null if not found.
	}

	@Override
	public Course deleteCourse(Long course_id) {
		SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Course courseToDelete = session.get(Course.class, course_id);

		try {
			transaction = session.beginTransaction();
			session.delete(courseToDelete);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.commit();
			}
			e.printStackTrace();
		}

		return courseToDelete;
	}

	@Override
	public List<Course> getCourse() {

		return null;
	}

}
