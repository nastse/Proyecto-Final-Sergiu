package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.registery.RegisteryDAO;
import com.demo.pojo.User;

@Controller
@RequestMapping(value= { "/", "/index"})
public class Index_Controller {
	

	@RequestMapping(value= { "/", "/index"}, method=RequestMethod.GET)
	public ModelAndView loadProducts() {
		
	//PARA CONSULTA HQL
		ModelAndView mav = new ModelAndView("index");
	
	//PARA CONSULTA SQL	
		//ModelAndView mav = new ModelAndView("products_1");
		
		//CREO UN MAV QUE DEVUELVE LA LISTA DE TODOS LOS PRODUCTOS PARA PODER USARLA EN EL JSP
		//Products_Model pm = new Products_Model();
	//HQL	
		//mav.addObject("allProducts", pm.getAllProducts());
	//SQL	
		//mav.addObject("allProducts", pm.getAllProductsSQL());
	//USANDO DAO
		
		User user = new User();
		mav.addObject("allProducts", RegisteryDAO.getProductsDAO().getAllProducts());
		mav.addObject("user", user);
		
		return mav;
		
	}
	
	
	@RequestMapping(value= { "/", "/index"}, method=RequestMethod.POST)
	public String do_login(HttpServletRequest req, Model md, HttpSession session, @Valid User user, BindingResult br) {
		
		try {
			
			//System.out.println(br.getAllErrors().size());
			
			String username= req.getParameter("email");
			String password= req.getParameter("password");
			
			System.out.println("Usuario: " +username + " Pass: " +password);
			
			//Si hay algun error de validacion no hago nada
			if(br.getAllErrors().size() > 0) {
			
				System.out.println("Se ha validad por el lado servidor");
				
			//Si no hay ningun error me compruebo mi User y password para loguearme 	
			}else{
				
				//MODELO DAO
				int message = RegisteryDAO.getUserDAO().doHibernateLogin(username, password);
				
				if(message != 0) {
					
					//RECOJO LA SESION Y LE ASIGNO UN NOMBRE
					session.setAttribute("email", username);
					return "redirect:/myprofile";
					
				}else {
					
					md.addAttribute("error_msg", message);
					
				}
			}
			
			return "index";
			
		}catch(Exception e){
			
			return "index";
		}
	}
			
}