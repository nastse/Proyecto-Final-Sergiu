package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.registery.RegisteryDAO;


@Controller
@RequestMapping(value= {"/vista/{id}"})
public class VistaProducto_Controlller {
	
	//RECOJO LA ID QUE MANDO EN LA PANTALLA MIPERFIL CON EL PRODUCTO SELECCIONADO
	@RequestMapping(name="/vista/{id}", method = RequestMethod.GET)
	public ModelAndView vista_producto(@PathVariable("id")int id) {
	
		ModelAndView mav = new ModelAndView("vista");
		System.out.println("hola"+id);
		
		//TODO Usar la ID recibida para hacer busqueda de producto y cargar vista.jsp con el
		
		return mav;
	}
	

	
	/*
	@RequestMapping(name= "/vista", method=RequestMethod.GET)
	public ModelAndView vista_normal() {
	
		ModelAndView mav = new ModelAndView("vista");
		
		
		return mav;
	}*/
	
	
	
}


