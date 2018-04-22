package com.demo.controllers;

import java.io.File;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.registery.RegisteryDAO;
import com.demo.pojo.User;



@Controller
@MultipartConfig
public class Signup_Controller
{
	@RequestMapping(value="/signup" , method=RequestMethod.GET)
	public ModelAndView load_signup()
	{
		ModelAndView mav = new ModelAndView("signup");
		//AÑADIDO PRUEBA 2 LINEAS
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}
	
	/*
	//MODELO PARA FORMULARIO CON SUBIDA DE ARCHIVOS
	@RequestMapping(value="/signup" , method=RequestMethod.POST)
	public ModelAndView doSignUpProcess(HttpServletRequest request, @Valid User user, BindingResult br)
	{
		ModelAndView mav = new ModelAndView("signup");
		
		String message = "";
		
		if(ServletFileUpload.isMultipartContent(request))
		{
			try
			{
			List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			
			String email = data.get(0).getString();
			String password = data.get(1).getString();
			String repassword = data.get(2).getString();
			
			
			//String image = new File(data.get(6).getName()).getName();
			//System.out.println(username + " " +password);
			
			//Creo un objeto de usuerio
			//User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			
			 if(password.equals(repassword))
			{
				//Signup_Model sm = new Signup_Model();
				
				//INSERTAR UN USUARIO EN LA BDDA TIPO SQL
				//message = sm.doSignUp(username, repassword, gender, vehicle, country, image);
				
				//INSERTAR UN USUARIO EN LA BDDA TIPO HQL
				//message=sm.doHibernateSignUp(user);
				//MODELO TIPO DAO
				message = RegisteryDAO.getUserDAO().doHibernateSignUp(user);
				
				//String path = request.getSession().getServletContext().getRealPath("/") + "//WEB-INF//images//";
				
				//data.get(6).write(new File(path + File.separator + image));
				
			}
			else
			{
				message = "Password does not match..please try again";
			}
			
			}
			catch(Exception e)
			{
				System.out.println(e);
				message = "Please try again....";
			}
		}
			
		mav.addObject("message", message);
			
		return mav;
	}*/
	
	
	
	@RequestMapping(value="/signup" , method=RequestMethod.POST)
	public ModelAndView doSignUpProcess(HttpServletRequest request, Model md, @Valid User user, BindingResult br)
	{
		ModelAndView mav = new ModelAndView("signup");
		
		String message = "";
		
	
			try
			{
			//List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repassword");
			
			if(br.getAllErrors().size() > 0) {
				
				System.out.println("Se ha validado");
				
			//Si no hay ningun error me compruebo mi User y password para loguearme 	
			}else {
				
				//Creo un objeto de usuerio
				//User user = new User();
				user.setEmail(email);
				user.setPassword(password);
				user.setRepassword(repassword);
				
				 if(password.equals(repassword))
				{
					//Signup_Model sm = new Signup_Model();
					
					//MODELO TIPO DAO
					message = RegisteryDAO.getUserDAO().doHibernateSignUp(user);
					
				//SI LA ALTA ES BUENA VOY A MI PAGINA DE PERFIL Y CARGO MIS DATOS CON EL FORMULARIO PARA COMPLETAR
					/*//RECOJO LA SESION Y LE ASIGNO UN NOMBRE
					session.setAttribute("email", username);
					return "redirect:/myprofile";*/

				}
				else
				{
					message = "Password does not match..please try again";
					md.addAttribute("error_msg", message);
				}
				
			}
			
			
			}
			catch(Exception e)
			{
				System.out.println(e);
				message = "Please try again....";
			}
		
			
		mav.addObject("message", message);
			
		return mav;
	}
	
	
	
	
	
	@RequestMapping(value="/dynamic/{message}" , method=RequestMethod.GET)
	public ModelAndView dynamicDemo(@PathVariable("message") String message)
	{
		ModelAndView mav = new ModelAndView("signup");
		System.out.println(message);
		return mav;
	}
}