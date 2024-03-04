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

import org.Model.HotelModel;
import org.techhub.service.HotelService;


@WebServlet("/viewhotel")
public class ViewHotelController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		HotelService hotelService=new HotelService(); 	
		List<HotelModel> list=hotelService.getAllHotels();
		out.println("<table border='5' align='center' width='400px;'>");
		out.println("<tr><th>HotelName</th><th>DELETE</th><th>UPDATE</th></tr>");
		for(HotelModel h:list) {
			out.println("<tr>");
			out.println("<td>"+h.getName()+"</td>");
			out.println("<td><a href='del?hotelId="+h.getId()+"'>DELETE</a></td>");
			out.println("<td><a href='updatehotel?hotelId="+h.getId()+"&hotelName="+h.getName()+"'>UPDATE</a></td>");
			
			out.println("</tr>");
		}
		out.println("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
