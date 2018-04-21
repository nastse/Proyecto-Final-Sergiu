package com.demo.models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.demo.pojo.User;

public class Login_Model {
	
	//USANDO SQL
	/*public String do_login_process(String username, String password) {
		
		try {
			
			Database_Connectivity dc = new Database_Connectivity();
			Statement statement = dc.do_db_connection();
			
			ResultSet rs = statement.executeQuery("select count(*) from usuario where email='"+username+"' and password='"+password+"'");
			int count = 0;
			
			while(rs.next()) {
				
				count = rs.getInt(1);
			}
			
			rs.close();
			
			if(count ==1) {

				return "Login Correcto";	
			}else {

				return "Usuario o contraseña incorrectos";
			}
			
			
		}catch(Exception e){
			
			return "Ha ocurrido un error, vuelve a intentarlo";
		}
		
	}*/
	
	//USANDO HQL
	public String doHibernateLogin(String email, String password) {
		
		try {
			
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			//Consulta HLO
			List<User> user = session.createQuery("From User where email='"+email+"'and password='"+password+"'").list();
			
			//Cerramos la sesion
			session.close();
			
			if(user.size()==1) return "Login Correcto";
			
			else return "Error vuelve a intenarlo";
			
			
		}catch(Exception e) {
			return "Intentalo de nuevo";
		}
		
	}

}
