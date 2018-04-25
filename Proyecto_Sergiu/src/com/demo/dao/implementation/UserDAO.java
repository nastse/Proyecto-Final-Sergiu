package com.demo.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.demo.dao.implementation.HibernateConnection;
import com.demo.pojo.User;

public class UserDAO implements com.demo.dao.layer.UserDAO{
	
	//USANDO HQL
	//DEVUELVO UN INT PARA RECOGER EL ID DEL USUARIO Y HACER LA CONSULTA
		public int doHibernateLogin(String username, String password) {
			
			try {
				
				SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
				Session session = sessionFactory.openSession();
				
				session.beginTransaction();
				
				//Consulta HLO
				List<User> user = session.createQuery("From User where email='"+username+"'and password='"+password+"'").list();
				
				//Cerramos la sesion
				session.close();
				
				if(user.size()==1) return user.get(0).getId_usuario();
				
				else return 0;
				
				
			}catch(Exception e) {
				return 0;
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
