package com.demo.models;

import java.util.List;

import org.hibernate.Session;

import com.demo.pojo.Products;

public class Products_Model {
	
	
	//PARA QUERYS TIPO HQL
	//LO PASO A DAO.IMPLEMENTACION Y LO LLAMO EN DAO.LAYER
	public List<Products> getAllProducts(){
		
		//CREO LA SESION DE HIBERNATE - NECESITO CREAR UN CONTROLADOR
		Session session = HibernateConnection.doHibernateConnection().openSession();
		
		List<Products> allProducts = session.createQuery("From Products").list();
		session.close();
		
		//DEVUELVE UN POJO
		return allProducts;
	}

	
	//PARA QUERYS TIPO SQL
	public List<Object[]> getAllProductsSQL(){
			
		Session session = HibernateConnection.doHibernateConnection().openSession();
			
		List<Object[]> allProducts = session.createSQLQuery("Select * from products").list();
		session.close();
			
		return allProducts;
	}
		
}
