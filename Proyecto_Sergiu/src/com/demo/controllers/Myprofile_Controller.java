package com.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.registery.RegisteryDAO;
import com.demo.pojo.Products;

@Controller
public class Myprofile_Controller {

		@RequestMapping(value="/myprofile", method=RequestMethod.GET)
		//public ModelAndView load_myprofile(HttpSession session, ModelMap map) {
		
		public String load_myprofile(HttpSession session, ModelMap map) {	
			//ModelAndView mv = new ModelAndView("myprofile");
			
			//COMPRUEBO QUE EL USUARIO ESTA LOGUEADO
			if(session.getAttribute("email") != null) {
				
				
				//PARA RECIBIR EL NOMBRE DE LA SESION LE PASO EL NOMBRE DE LA CLAVE QUE LE ASIGNADO
				String email = session.getAttribute("email").toString();
				
				List<Products> reviews = (List<Products>)session.getAttribute("id");
				
				if(session.getAttribute("id")  == null) {
					
					System.out.println("VALOR NULL SESION ID");
				}
				
				//mv.addObject("user", username);
				map.addAttribute("email", email);
				
				map.addAttribute("listaReviews", reviews);
				//System.out.println(md);
			}
			
			return "myprofile";
		}
}
