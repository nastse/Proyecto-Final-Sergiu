package com.demo.dao.implementation;

import java.util.List;

import org.hibernate.Session;

//CAMBIO
//import com.demo.models.HibernateConnection;
import com.demo.dao.implementation.HibernateConnection;

import com.demo.pojo.Products;

public class ProductsDAO implements com.demo.dao.layer.ProductsDAO {

//DEVUELVO LA LISTA DE PRODUCTOS	
	//SUSTITUYO LOS MODELS POR DAO
	public List<Products> getAllProducts(){
		
		//CREO LA SESION DE HIBERNATE - NECESITO CREAR UN CONTROLADOR
		Session session = HibernateConnection.doHibernateConnection().openSession();
		
		List<Products> allProducts = session.createQuery("From Products").list();
		session.close();
		
		//DEVUELVE UN POJO
		return allProducts;
	}

//BORRAR UN PRODUCTO
	public boolean deleteProductById(String id){
		try{
			Session session = HibernateConnection.doHibernateConnection().openSession();
			
			List<Products> product = session.createQuery("From Products where id='"+id+"'").list();
			
			if(product != null && product.get(0) != null){
				session.beginTransaction();
				session.delete(product.get(0));
				session.getTransaction().commit();
				session.close();
			}
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

//DEVUELVO UN PRODUCTO POR SU ID
	public Products getProductByProductId(String id) {
		try {
			
			Session session = HibernateConnection.doHibernateConnection().openSession();
			
			List <Products> product = session.createQuery("From Products where id_rev='"+id+"'").list();
			
			//SOLO DEVUELVE UNO PORQUE ID ES PK
			return product.get(0);
			
		}catch(Exception e) {
			
			return null;
		}
	}
	
	
	//DEVUELVO LISTA DE PRODUCTOS POR SU ID DE USUARIO
		public List<Products> getProductByUserId(int id) {
			try {
				
				Session session = HibernateConnection.doHibernateConnection().openSession();
				
				List <Products> productosId = session.createQuery("From Products where id_user='"+id+"')").list();
				session.close();
				
				return productosId;
				
			}catch(Exception e) {
				
				return null;
			}
		}
		
	//ACTUALIZAR UN PRODUCTO
		public String updateProduct(Products product) {
			
			Session session = HibernateConnection.doHibernateConnection().openSession();
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
			session.close();
			
			return "Producto actualizado correctamente";
			
		}
		
		/*//DEVUELVO LISTA DE PRODUCTOS POR SU NOMBRE DE USUARIO
	//NO FUNCIONA	
				public List<Products> getProductByUserName(String user) {
					try {
						
						Session session = HibernateConnection.doHibernateConnection().openSession();
						
						List <Products> productosId = session.createQuery("Select * from Products p, User u, where p.id_user=u.id_usuario and u.email='"+user+"')").list();
						session.close();
						
						return productosId;
						
					}catch(Exception e) {
						
						return null;
					}
				}*/
	
}
