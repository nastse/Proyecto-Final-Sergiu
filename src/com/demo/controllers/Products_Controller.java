package com.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.registery.RegisteryDAO;
import com.demo.pojo.Products;




@Controller
@RequestMapping(value= { "/products"})
public class Products_Controller {
	

	@RequestMapping(name="/products", method=RequestMethod.GET)
	public ModelAndView loadProducts() {
		
	//PARA CONSULTA HQL
		ModelAndView mav = new ModelAndView("products");
	
	//PARA CONSULTA SQL	
		//ModelAndView mav = new ModelAndView("products_1");
		
		//CREO UN MAV QUE DEVUELVE LA LISTA DE TODOS LOS PRODUCTOS PARA PODER USARLA EN EL JSP
		//Products_Model pm = new Products_Model();
	//HQL	
		//mav.addObject("allProducts", pm.getAllProducts());
	//SQL	
		//mav.addObject("allProducts", pm.getAllProductsSQL());
	//USANDO DAO
		mav.addObject("allProducts", RegisteryDAO.getProductsDAO().getAllProducts());
		
		
		return mav;
		
	}
	

}



