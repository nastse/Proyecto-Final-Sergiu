package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value= {"/error"})
public class Error_Controller {
	
	@RequestMapping(value= { "/error"}, method=RequestMethod.GET)
	public ModelAndView paginaError() {
		
		ModelAndView mav = new ModelAndView("error");
		
		return mav;
	
	}

}
