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

import org.Model.RegisterModel;
import org.techhub.service.UserService;

@WebServlet("/viewprofile")
public class ViewProfile extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("usermaster.html");
		r.include(request, response);
		out.println("<br><br>");
		HttpSession session=request.getSession();
		Object userId=session.getAttribute("uid");
		int loginUserId=Integer.parseInt(userId.toString());
		UserService userService=new UserService();
		RegisterModel regModel=userService.getUserProfile(loginUserId);	
		if(regModel!=null) {
			out.println("<center>");
			out.println("<h1>Name is &nbsp;&nbsp;"+regModel.getName()+"</h1>");
			out.println("<h1>Email is &nbsp;&nbsp;"+regModel.getEmail()+"</h1>");
			out.println("<h1>Contact is &nbsp;&nbsp;"+regModel.getContact()+"</h1>");
			out.println("<h1>Username is &nbsp;&nbsp;"+regModel.getUsername()+"</h1>");
			out.println("<h1>Password is &nbsp;&nbsp;"+regModel.getPassword()+"</h1>");
			out.println("</center>");
		}
		else {
			out.println("<h1>Some problem is there</h1>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
