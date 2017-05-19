package com.hellokoding.springboot.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class adapter{
	public String layND(){
		String ss="";
		chuoikn s=new chuoikn();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		Connection con=null;
		Statement stm=null;
		ResultSet rs;	
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","1234");
			//con=DriverManager.getConnection(s.getSQL(),s.getName(),s.getPass());
			stm=con.createStatement();
			rs=stm.executeQuery("select * from hello");
			
		if(rs.next())
			ss=rs.getString("mess");
		}catch(SQLException e){
			e.printStackTrace();
		}	
		finally
		{
				try {
					con.close();
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		return ss;
	}
	public boolean CapNhat(String noidung)
	{				
		chuoikn s = new chuoikn();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		Connection con=null;
		Statement stm=null;
		
		try
		{
			
			con=DriverManager.getConnection(s.getSQL(),s.getName(),s.getPass());
			stm=con.createStatement();
			String sql="UPDATE `hello` SET `mess`= '"+noidung+"'";
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			return pst.executeUpdate() > 0;						
					
		}catch(SQLException e){
			e.printStackTrace();
		}	
		finally
		{
			
				try {
					con.close();
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		}
			
		return false;
	}
}