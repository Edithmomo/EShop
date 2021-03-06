package org.ccunix.eshop.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DBManager {
	public static Connection getConnection() {
		Connection connection = null;
		Properties properties = new Properties();
		try {
			InputStream is = DBManager.class.getClassLoader()
					.getResourceAsStream("config/database.properties");
			properties.load(is);

			Class.forName(properties.getProperty("driver"));
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			connection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	public static void close(Connection connection, Statement statement) {
		try {
			if (connection != null && connection.isClosed() == false) {
				connection.close();
			}
			if (statement != null && statement.isClosed() == false) {
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static SessionFactory factory;
	static {
		Configuration configuration = new Configuration();
		Configuration cfg = configuration.configure("config/hibernate.xml");
		factory = cfg.buildSessionFactory();
	}

	public static Session getSession() {
		if (factory != null) {
			return factory.openSession();
		}
		return null;
	}

	public static void closeSession(Session session){
		if(session != null){
			session.close();
		}
	}
	public static Transaction getTransation(Session session){
		if(session != null && session.isOpen()){
			return session.beginTransaction();
		}
		return null;
	}
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(DBManager.getConnection());
		getSession();
	}

}
