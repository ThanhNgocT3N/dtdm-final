package com.hellokoding.springboot.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class data {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "1234";
	public Connection connect() {
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
