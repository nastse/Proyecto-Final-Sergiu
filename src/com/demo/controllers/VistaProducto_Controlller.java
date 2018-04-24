package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.registery.RegisteryDAO;


@Controller
@RequestMapping(value= {"/vista/*"})
public class VistaProducto_Controlller {
	
	
	@RequestMapping(name="/vista/{id}", method=RequestMethod.GET)
	public String vista_producto(@PathVariable(value="id") int id) {
	
		ModelAndView mav = new ModelAndView("vista");
		System.out.println(id);
		
		return null;
	}
	
	
}


