package hibernateConfigurationPackage;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javaBeans.Course;
import javaBeans.Student;

// In this class, we have created a lazy Singleton Class which means the instance is created only when needed.

public class HibernateConfiguration {

	private static HibernateConfiguration instance;
	private SessionFactory sessionFactory;
	Configuration config;

	private HibernateConfiguration() {
		try {
			config = new Configuration();

			// Set database connection properties
			config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/your_database");
			config.setProperty("hibernate.connection.username", "root");
			config.setProperty("hibernate.connection.password", "August$106317");

			// Automatically update the schema
			config.setProperty("hibernate.hbm2ddl.auto", "update");

			// Add your entity class to the configuration
			config.addPackage("rootPackage").addAnnotatedClass(Student.class).addAnnotatedClass(Course.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static HibernateConfiguration getInstance() {
		if (instance == null) {
			synchronized (HibernateConfiguration.class) {

				instance = new HibernateConfiguration();

			}
		}
		return instance;
	}

	public SessionFactory getSessionFactory() {

		return config.buildSessionFactory();
	}
}
