package com.demo.models;

import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;

import com.demo.pojo.User;

public class Signup_Model {
	
	public String doSignUp(String username , String password , String gender , String vehicle , String country , String image)
	{
		try
		{
			Database_Connectivity dc = new Database_Connectivity();
			Statement statment = dc.do_db_connection();
			
			statment.execute("insert into user values('"+username+"' , '"+password+"' , '"+gender+"' , '"+vehicle+"' , '"+country+"' , '"+image+"')");
			
			return "Sign Up Successfully...";
		}
		catch(Exception e)
		{
			System.out.println(e);
			return "Something went wrong pelase try again ! ! !";
		}
	}
	
	//INSERTAR EN LA BASE DE DATOS CON HIBERNATE
	public String doHibernateSignUp(User user) {
		
		try {
			
			Session session = HibernateConnection.doHibernateConnection().openSession();
			session.beginTransaction();
		//SI DA ERROR ES POR QUE EL USUARIO YA EXISTE
			session.save(user);
			
		//PARA HACER UN UPDATE
			//session.update(user);
			
		//PARA UNA LISTA CON VARIAS FILAS A INSERTAR
			//List<User> user1 = null;
			//session.save(user1);
			
		//PARA ACTUALIZAR UNA FILA SI ESTA EXISTE O INSERTARLA SI NO EXISTE
		//COMPRUEBA SOLO LA PRIMARY KEY Y SI EXISTE LA ACTUALIZA EN VEZ DE AÑADIR UNA NUEVA	
			//session.saveOrUpdate(user);
			
		//PARA HACER UN DELETE
			//session.delete(user);
			
		//IMPORTANTE AÑADIR PARA INSERTAR DATOS EN LA BASE DE DATOS
			session.getTransaction().commit();
			session.close();
			
			return "Sign Up Successfully...";
			
		}catch(Exception e) {
			
			e.printStackTrace();
			return "El usuario ya existe";
		}
		
	}

}
