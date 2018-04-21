package com.demo.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database_Connectivity {
	
	Connection conn;
	Statement statement;
	
	String url ="jdbc:mysql://localhost:3306/";
	String db_name = "proyecto_sergiu";
	String username = "root";
	String password = "";
	
	public Statement do_db_connection() {
		
		 try{
			 Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(url+db_name, username, password);
			 statement = conn.createStatement();
			 
			 return statement;
		 }
		 catch(ClassNotFoundException e) {
			 System.out.println("Error de conexion 1");
			 return null;
		 }
		 catch(SQLException  e) {
			 System.out.println("Error de conexion 2");
			 return null;
		 }
		 catch(Exception e) {
			 System.out.println("Error de conexion 3");
			 return null;
		 }
	}
	
	
	//HAGO PRUEBA PARA COMPROBAR LA CONEXION
	/*public static void main(String[] args) {
		Database_Connectivity d1 = new Database_Connectivity();
		
		Statement statement2 = d1.do_db_connection();
		try {
			ResultSet rs = statement2.executeQuery("select * from user");
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/

}
