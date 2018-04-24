package com.demo.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.registery.RegisteryDAO;
import com.demo.pojo.Products;
import com.demo.pojo.User;

@Controller
//Clase controladora que devuelve un MAV o un String para redirigir a la pagina
public class Login_Controller {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	//Recojo el valor de la cookie para ir sumandole valor mas adelante
	public ModelAndView loadloginpage(HttpServletResponse response, @CookieValue(value="hits", defaultValue="0") Long hits) {
		
		ModelAndView mav = new ModelAndView("login");
		System.out.println("Se ha llamado al metodo login");
		
		User user = new User();
		mav.addObject("user", user);
		
		//Incremento el valor de la cookie para despues reasignarla de nuevo
		hits++;
		//Creo una cookie para guardarla en el navegador del cliente
		//para contar las veces que se ha conectado
		Cookie cookie = new Cookie("hits", hits.toString());
		//cookie.setMaxAge(90);
		response.addCookie(cookie);
		
		
		return mav;
	}
	
	/*@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loadloaginpage() {
		
		return "login";
	}*/
	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String do_login(HttpServletRequest req, Model md, HttpSession session, @Valid User user, BindingResult br) {
		
		try {
			
			//System.out.println(br.getAllErrors().size());
			
			//LO RECOJO DEL PATH QUE ASIGNO EN EL JSP
			String username= req.getParameter("email");
			String password= req.getParameter("password");
			
			System.out.println("Usuario: " +username + " Pass: " +password);
			
			//Si hay algun error de validacion no hago nada
			if(br.getAllErrors().size() > 0) {
			
				System.out.println("Se ha validad por el lado servidor");
				
			//Si no hay ningun error me compruebo mi User y password para loguearme 	
			}else {
				
				//Login_Model lm = new Login_Model();
				//LOGUE USANDO CONSULTA HQL
				//String message = lm.doHibernateLogin(username, password);
				//MODELO DAO
				int message = RegisteryDAO.getUserDAO().doHibernateLogin(username, password);
				
				//HAGO UNA BUSQUEDA DE TODOS LOS PRODUCTOS DE UN USUARIO POR SU ID RECOGIDO ANTES
				List <Products> reviews = RegisteryDAO.getProductsDAO().getProductByUserId(message);
				
				
				if(message != 0) {
					
					//RECOJO LA SESION Y LE ASIGNO UN NOMBRE
					session.setAttribute("email", username);
					
					//RECOJO LA SESION Y LE ASIGNO UN NOMBRE
					session.setAttribute("id", reviews);
					
					
					return "redirect:/myprofile";
					
				}else {
					
					md.addAttribute("error_msg", message);
				}
	
			}

			return "login";
			
		}catch(Exception e){
			
			return "login";
		}
	}
	

}
