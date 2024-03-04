package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Model.HotelInfoModel;
import org.techhub.service.HotelService;


@WebServlet("/viewhotelinfo")
public class ViewHotelInfoController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		out.println("<br><br>");
		out.println("<table border='5' align='center' width='70%'>");
		out.println("<tr><th>NAME</th><th>EMAIL</th><th>CONTACT</th><th>Location</th><th>ADDRESS</th><th>DELETE</th><th>UPDATE</th></tr>");
		 List<HotelInfoModel> list = new HotelService().getHotelList();
		
		for(HotelInfoModel m : list) {
			out.println("<tr>");
			out.println("<td>"+m.getName()+"</td>");
			out.println("<td>"+m.getEmail()+"</td>");
			out.println("<td>"+m.getContact()+"</td>");
			out.println("<td>"+m.getLocation()+"</td>");
			out.println("<td>"+m.getAddress()+"</td>");
			out.println("<td><a href=''>DELETE</td>");
			out.println("<td><a href=''>UPDATE</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
