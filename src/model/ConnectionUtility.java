package model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtility {
	private static ConnectionUtility utility;
	private Properties prop;private String username,password,url,driver;
	private  ThreadLocal<Connection> tlocal;
	private ConnectionUtility() {
		System.out.println("connection utility....object created...");
		try {
			
			tlocal=new ThreadLocal<Connection>();
			prop=new Properties();
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			prop.load(classLoader.getResourceAsStream("dbconfig.properties"));
			
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			url=prop.getProperty("url");
			driver=prop.getProperty("driver");
			
//			username="root";
//			password="root";
//			url="jdbc:mysql://localhost:3306/billing2";
//			driver="com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized static ConnectionUtility getConnectionUtility() {
		if(utility==null) {
			utility=new ConnectionUtility();
		}
		return utility;		
	}
	public Connection getConnection() {
		try {
			Connection con=tlocal.get();
			if(con==null) {
				con=DriverManager.getConnection(url,username,password);
				con.setAutoCommit(false);
				tlocal.set(con);
			}
			return con;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void killConnection(Connection con) {
		try {
			con=tlocal.get();
			if(con!=null) {
				con.close();
				tlocal.remove();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
