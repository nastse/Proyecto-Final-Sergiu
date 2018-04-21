package com.demo.controllers;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.registery.RegisteryDAO;
import com.demo.pojo.Products;

@RestController
public class RestProvider_Controller {
	
	//METODO QUE RESPONDE A LA PETICION DE UN CONSUMIDOR
	//DEVUELVE LA PETICION DE UN PRODUCTO POR SU ID
	@RequestMapping(value="/jsonGetProductById/{productId}", method=RequestMethod.GET)
	public String jsonGetProductById(@PathVariable("productId") String productId) {
		
		//DEVUELVO EL JSON A FORMATO STRING
		Products product = RegisteryDAO.getProductsDAO().getProductByProductId(productId);
		
		//CONCATENO EL NOMBRE DE LA IMAGE CON EL LINK PARA VISUALIZARLA
		product.setImagen("http://localhost:8081/Spring_Web_App/img/"+product.getImagen());
		
		JSONObject json = new JSONObject(product);
		
		return json.toString();
	}
	
	//DEVUELVE LA PETICION DE TODOS LOS PRODUCTOS
	@RequestMapping(value="/jsonGetAllProducts", method=RequestMethod.GET)
	public String jsonGetAllProducts() {
		
		List<Products> products = RegisteryDAO.getProductsDAO().getAllProducts();
		JSONArray jArray = new JSONArray();
		
		for(Products product : products) {
			//CREO UN JSON POR CADA PRODUCTO
			product.setImagen("http://localhost:8081/Spring_Web_App/img/"+product.getImagen());
			JSONObject json = new JSONObject(product);
			jArray.put(json);
			
		}
		
		return jArray.toString();
	}
	
	
	@RequestMapping(value="/xmlGetProductById/{productId}", method=RequestMethod.GET)
	public Products xmlGetProductById(@PathVariable("productId") String productId) {
		
		Products product = RegisteryDAO.getProductsDAO().getProductByProductId(productId);
		product.setImagen("http://localhost:8081/Spring_Web_App/img/"+product.getImagen());
		
		//DEVUELVO UN POJO DE PRODUCTO
		return product;
	}
	
	
}
