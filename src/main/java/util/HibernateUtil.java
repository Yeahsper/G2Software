<<<<<<< HEAD
package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    //Just standard settings if you dont wanna use LoginGUI to use the program.
    //This gets overwritten in LoginGUI.
    private static String username = "javauser";
    private static String password = "java";
    private static String dbConnection = "jdbc:mysql://localhost:3330/sakila?serverTimezone=UTC";


    //XML based configuration
    private static SessionFactory sessionFactory;
    private static SessionFactory buildSessionFactory() {


        try {
            // Create the SessionFactory from line configuration.configre(file)
            // And overwrites the configuration.
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.setProperty("hibernate.connection.url", dbConnection);
            configuration.setProperty("hibernate.connection.username",username);
            configuration.setProperty("hibernate.connection.password",password);
            configuration.setProperty("format_sql", "true");

            System.out.println("Hibernate Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate ServiceRegistry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
    public static void shutdown() {
        getSessionFactory().close();
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        HibernateUtil.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        HibernateUtil.password = password;
    }

    public static String getDbConnection() {
        return dbConnection;
    }

    public static void setDbConnection(String dbConnection) {
        HibernateUtil.dbConnection = dbConnection;
    }



=======
package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	//Just standard settings if you dont wanna use LoginGUI to use the program.
	//This gets overwritten in LoginGUI.
	private static String username = "javauser";
	private static String password = "java";
	private static String dbConnection = "jdbc:mysql://localhost/sakila?serverTimezone=UTC";


	//XML based configuration
	private static SessionFactory sessionFactory;
	private static SessionFactory buildSessionFactory() {


		try {
			// Create the SessionFactory from line configuration.configre(file)
			// And overwrites the configuration.
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.setProperty("hibernate.connection.url", dbConnection);
			configuration.setProperty("hibernate.connection.username",username);
			configuration.setProperty("hibernate.connection.password",password);
			configuration.setProperty("format_sql", "true");

			System.out.println("Hibernate Configuration loaded");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			System.out.println("Hibernate ServiceRegistry created");

			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			sessionFactory = configuration.buildSessionFactory();
			return sessionFactory;
		}
		catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
		return sessionFactory;
	}
	public static void shutdown() {
		getSessionFactory().close();
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		HibernateUtil.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		HibernateUtil.password = password;
	}

	public static String getDbConnection() {
		return dbConnection;
	}

	public static void setDbConnection(String dbConnection) {
		HibernateUtil.dbConnection = dbConnection;
	}



>>>>>>> 7ad9c1f48d3c27f1063813632e418ec3c0b70591
}