package daoImpPackage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import daoPackage.StudentDao;
import hibernateConfigurationPackage.HibernateConfiguration;
import javaBeans.Student;
import org.hibernate.Transaction;

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
		// TODO Auto-generated method stub
		return null;
	}

}
