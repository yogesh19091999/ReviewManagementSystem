package org.techhub.repository;
import java.sql.*;
public class DBConfig {
	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	public DBConfig() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/review","root","Pass@123");
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
		}
	}
	
}
