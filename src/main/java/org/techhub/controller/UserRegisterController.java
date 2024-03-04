package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Model.RegisterModel;
import org.techhub.service.UserService;

@WebServlet("/userReg")
public class UserRegisterController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		RegisterModel model = new RegisterModel();
		model.setName(name);
		model.setEmail(email);
		model.setContact(contact);
		model.setUsername(username);
		model.setPassword(password);	
		UserService userService = new UserService();
		boolean b=userService.isRegisterUser(model);
		if(b) {
			out.println("<center><h1>User Register Success...........</h1></center>");
			out.println("<h3>Now you can login to application &nbsp;&nbsp;<a href='userlogin.jsp'>Login</a></h3>");
		}
		else {
			out.println("<center><h1>Registration Failed...........</h1></center>");

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
