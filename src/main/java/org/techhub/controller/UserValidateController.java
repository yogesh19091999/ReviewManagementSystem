package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.Model.LoginModel;
import org.techhub.service.UserService;


@WebServlet("/userValidate")
public class UserValidateController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginModel model = new LoginModel();
		model.setUsername(username);
		model.setPassword(password);
		UserService userService=new UserService();
		int result=userService.validateUser(model);
		if(result!=-1) {
			HttpSession session=request.getSession(true);
			session.setAttribute("uid", result);//store user id in session
			RequestDispatcher r=request.getRequestDispatcher("usermaster.html");
			r.forward(request, response);
		}
		else {
			RequestDispatcher r=request.getRequestDispatcher("userlogin.jsp");
			r.include(request, response);
			out.println("<center>Invalid Login</center>");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
