package daoImpPackage;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import daoPackage.StudentDao;
import hibernateConfigurationPackage.HibernateConfiguration;
import javaBeans.Student;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Boolean addStudent(Student student) {
		SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(student);
			transaction.commit();
			return true;

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Student getStudent(Long student_id) {
		SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();

		Student student = session.get(Student.class, student_id);
		return student;
	}

	@Override
	public Student deleteStudent(Long student_id) {
		SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Student studentTodelete = session.get(Student.class, student_id);

		try {
			transaction = session.beginTransaction();
			session.delete(studentTodelete);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return studentTodelete;
	}

	@Override
	public List<Student> getStudent() {
		List<Student> students = new ArrayList<>();
		SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			// Use HQL (Hibernate Query Language) to retrieve all students
			Query<Student> query = session.createQuery("FROM Student", Student.class);
			students = query.list();
		} catch (HibernateException e) {
			// Handle Hibernate exceptions
			e.printStackTrace();
		} finally {
			// Close the session in a finally block to ensure it gets closed
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return students;
	}

	@Override
	public Boolean updateStudent(Student student) {
		SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.update(student);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace(); // You might want to handle the exception more gracefully in a real application
			return false;
		} finally {
			session.close();
		}
	}

}
